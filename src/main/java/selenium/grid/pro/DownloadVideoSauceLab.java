package selenium.grid.pro;

import org.testng.annotations.Test;

import com.saucelabs.saucerest.SauceREST;

public class DownloadVideoSauceLab {
	
	@Test
	public void sauceVidoe(/*String jobId*/) {
		SauceREST sR = new SauceREST("GopinathJayakumar", 
				"23772337-4dcb-46aa-9e96-0872bb17a0d7");
		CharSequence fJob ="";
		String[] x = sR.getJobs().split(",");
		for (String eachX : x) {	
			fJob=eachX.subSequence(9, 41);
			break;
		}
//	 System.out.println(SauceREST.getExtraUserAgent());	
		sR.downloadLog(""+fJob, "./sauceLogs");		 
		sR.downloadVideo(""+fJob,"./sauceVideos");
	}
}
