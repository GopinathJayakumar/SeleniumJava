package ja.git.pro;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.transport.CredentialsProviderUserInfo;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PushCodeToGitRepo {
	public Git git = null;

	@BeforeSuite
	public void createRepository() throws IllegalStateException, GitAPIException, IOException {
		//create Local Repository
		git = Git.init().setDirectory(new File("D:\\Experimental\\Gopi Experiments\\GopiProject")).call();
		Repository repo = git.getRepository();
		StoredConfig conf = repo.getConfig();		
		conf.setString("remote", "origin", "url", "https://github.com/GopinathJayakumar/G_Collections.git");
		conf.save();		 
	}

	@BeforeMethod
	public void statusCall() {

	}

	@Test(enabled = false)
	public void createConnection() throws IllegalStateException, GitAPIException, IOException {
		//create Local Repository
		git = Git.init().setDirectory(new File("D:\\Experimental\\Gopi Experiments\\GopiProject")).call();
		Repository repo = git.getRepository();		
		StoredConfig conf = repo.getConfig();		
		conf.setString("remote", "origin", "url", "https://github.com/GopinathJayakumar/G_Collections.git");
		conf.save();
		git.add().addFilepattern(".*").call();
		git.commit().setMessage("Sample Push").call();
		git.push()
		.setCredentialsProvider(new UsernamePasswordCredentialsProvider("gopinathjk7@gmail.com", "*****")).call();
	}

	@Test(groups = "")
	public void remoteAdd() throws URISyntaxException, GitAPIException, IOException {
		Repository repo = new FileRepository("D:\\Experimental\\Gopi Experiments\\GopiProject");
		git = new Git(repo); 		
		RemoteAddCommand rAc = git.remoteAdd();
		rAc.setName("origin");
		rAc.setUri(new URIish("https://github.com/GopinathJayakumar/GopiCollections.git"));
		rAc.call();
		PushCommand pCom = git.push();
		pCom.setCredentialsProvider(new UsernamePasswordCredentialsProvider("gopinathjk7@gmail.com", "******"));		
		pCom.add("pom.xml");		
		pCom.call();
	}


}
