package net.lessy.util.filefilter;

import java.io.File;
import java.io.FileFilter;

/**
 * FileFilter for checking on File-Extension
 */
public class FileExtensionFilter implements FileFilter
{
   /** Contains the File-Extension */
   private String extension;

   /**
    * Constructor
    * @param extension The Extension to filter on (Example: ".txt" => include the dot)
    */
   public FileExtensionFilter(String extension) {
      this.extension = extension;
   }

   /**
    * {@inheritDoc}
    * @return true if the file has the specified extension, i.e. if the file name ends
    *    with that extension
    */
   public boolean accept(File file) {

      // Only Files are checked
      if (!file.isFile()) {
         return false;
      }

      if (extension == null) {
         return true;
      }

      return file.getName().endsWith(extension);
   }

   public String getExtension() {
      return extension;
   }

   public void setExtension(String extension) {
      this.extension = extension;
   }
}
