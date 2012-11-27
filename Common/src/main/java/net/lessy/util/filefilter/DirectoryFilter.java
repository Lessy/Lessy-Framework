package net.lessy.util.filefilter;

import java.io.File;
import java.io.FileFilter;

/**
 * Filter for Directories
 * @author Hans Lesmeister
 */
public class DirectoryFilter implements FileFilter {

   /**
    * {@inheritDoc}<br/>
    * Checks if the specified file is a directory
    * @param file the file to check
    * @return true if the file is a directory, otherwise false
    */
   public boolean accept(File file)
   {
      return ((file != null) && file.isDirectory());
   }
}
