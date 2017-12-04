//package org.somrainc.com.conf.beans;
//
//import org.somrainc.com.annotation.S3BeanQualifier;
//import org.somrainc.com.component.UploaderInterface;
//import org.somrainc.com.conf.condition.FTPCondition;
//import org.somrainc.com.conf.condition.S3Condition;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Conditional;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//public class UploaderProvider {
//
//    @Bean
//    @Conditional(S3Condition.class)
//    @Primary
//    public S3Uploader provideS3Uploader() {
//        return new S3Uploader();
//    }
//
//    @Bean
//    @Conditional(FTPCondition.class)
//    @Primary
//    public FTPUploader provideFTPUploader() {
//        return new FTPUploader();
//    }
//
//    public static class S3Uploader implements UploaderInterface {
//
//        @Override
//        public boolean uploadToServer() {
//            System.out.println("Uploading files to S3 bucket");
//            return true;
//        }
//
//    }
//
//    public static class FTPUploader implements UploaderInterface {
//        @Override
//        public boolean uploadToServer() {
//            System.out.println("Uploading files to FTP bucket");
//            return true;
//        }
//    }
//}
