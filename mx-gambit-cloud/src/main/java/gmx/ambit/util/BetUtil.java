package gmx.ambit.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Comparator;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class BetUtil {

	
	
//	public static void main(String args[]) {
//		toEmptyProccessDir("/tmp/files/codere_process/","procfile.json","/tmp/files/codere_output/");
//	}
//	
	public static String toEmptyProccessDir(String inputDir,String file,String outputDir) {
		return toProcessFile(inputDir, outputDir+file);
	}
	
	public static String toProcessFile(String inputDir,String procFile) {
		String namefile ="";
		File f = new File(inputDir);
		try {
			for(File s:dirListByAscendingDate(f)) {
				
				if(s.isFile()) {				
					try {
						namefile = s.getPath();
						Files.move(Paths.get(s.getAbsolutePath()), 
								Paths.get(procFile), StandardCopyOption.REPLACE_EXISTING);
						break;
					} catch (IOException e) {
						log.error("ERRORJIM: CANNOT REPLACE ON toProcessFile", e);
					}
				}				
			}
		}catch(ArrayIndexOutOfBoundsException e) {throw e;}
		return namefile;
	}

	 
	
	@SuppressWarnings("unchecked")
	  public static File[] dirListByAscendingDate(File folder) {
	    if (!folder.isDirectory()) {
	      return null;
	    }
	    File files[] = folder.listFiles();
	    if(files==null || files.length==0) {
	    	throw new ArrayIndexOutOfBoundsException();
	    }
	    Arrays.sort( files, new Comparator()
	    {
	      public int compare(final Object o1, final Object o2) {
	        return new Long(((File)o1).lastModified()).compareTo
	             (new Long(((File) o2).lastModified()));
	      }
	    }); 
	    return files;
	  }  
	  
	  @SuppressWarnings("unchecked")
	  public static File[] dirListByDescendingDate(File folder) {
	    if (!folder.isDirectory()) {
	      return null;
	    }
	    File files[] = folder.listFiles();
	    Arrays.sort( files, new Comparator()
	    {
	      public int compare(final Object o1, final Object o2) {
	        return new Long(((File)o2).lastModified()).compareTo
	             (new Long(((File) o1).lastModified()));
	      }
	    }); 
	    return files;
	  }

	public static void toDeleteFile(String procFile) {
		try {
			Files.deleteIfExists(Paths.get(procFile));
		} catch (IOException e) {
			log.error("Errorjim: cannot delete file "+procFile, e);
		}
		
	}  
}
