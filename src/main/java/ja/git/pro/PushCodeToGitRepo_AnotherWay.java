package ja.git.pro;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class PushCodeToGitRepo_AnotherWay {
	
	public static void main(String[] args) throws IOException, NoFilepatternException, GitAPIException {
		File workingDirectory = File.createTempFile("./git/gopiOne", "");
		workingDirectory.delete();
		workingDirectory.mkdirs();

		// Create a Repository object
		Repository repo = FileRepositoryBuilder.create(new File(workingDirectory, ".git"));
		repo.create();
		Git git = new Git(repo);

		// Create a new file and add it to the index
		File newFile = new File(workingDirectory, "myNewFile");
		newFile.createNewFile();
		git.add().addFilepattern("myNewFile").call();

		// Now, we do the commit with a message
	//	RevCommit rev = git.commit().setAuthor("gildas", "gildas@example.com").setMessage("My first commit").call();
	}

}
