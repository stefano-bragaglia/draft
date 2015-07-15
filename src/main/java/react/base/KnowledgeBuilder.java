package react.base;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by stefano on 12/07/2015.
 */
public interface KnowledgeBuilder extends RuleMemory {

	final Logger logger = LoggerFactory.getLogger(KnowledgeBuilder.class);

	/**
	 * @return
	 */
	public KnowledgeGraph newKnowledgeGraph(@NotNull Path folder);

	/**
	 * @param folder
	 */
	default void deleteKnowledgeGraph(final Path folder) {
		Objects.requireNonNull(folder);

		if (Files.exists(folder)) {
			if (Files.isDirectory(folder)) {
				try {
					DirectoryStream<Path> paths = Files.newDirectoryStream(folder);
					for (Path path : paths) {
						deleteKnowledgeGraph(path);
					}
					paths.close();
				} catch (IOException ignored) {
					logger.warn("Couldn't process folder '{}'", folder.getFileName().toString());
				}
			}
			try {
				Files.deleteIfExists(folder);
			} catch (IOException ignored) {
				logger.warn("Couldn't delete '{}'", folder.getFileName().toString());
			}
		}
	}

}
