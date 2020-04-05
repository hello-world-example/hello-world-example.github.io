package xyz.kail.demo.index;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, URISyntaxException {

        List<ProjectVO> projects = ProjectMetaData.readProjects();

        List<String> notImagesProject = IndexWriter.reWriteProject(projects);

        System.out.println(notImagesProject);

    }

}
