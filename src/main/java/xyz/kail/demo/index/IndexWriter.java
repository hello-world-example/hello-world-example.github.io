package xyz.kail.demo.index;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 */
public class IndexWriter {

    public static List<String> reWriteProject(List<ProjectVO> projects) throws URISyntaxException, IOException {
        Path indexPath = readIndexPath();

        Document document = Jsoup.parse(indexPath.toFile(), StandardCharsets.UTF_8.name());
        Element project = document.select("#datasouce .project").first();
        // 删除子节点
        project.children().remove();

        List<String> notImageProject = new ArrayList<>();

        projects.stream()
                // 记录没有图片的项目
                .peek(p -> {
                    if (Objects.isNull(p.getImage())) {
                        notImageProject.add(p.getName());
                    }
                })
                // 过滤没有图片的项目
                .filter(p -> Objects.nonNull(p.getImage()))
                // 增加子节点
                .forEach(p -> {
                    Element a = document.createElement("a");
                    a.attr("href", "//kail.xyz/" + p.getName());
                    a.attr("data-image", p.getImage());
                    a.text(p.getName());
                    project.appendChild(a);
                });

        // 覆盖文件
        Files.write(indexPath, document.toString().getBytes(StandardCharsets.UTF_8));

        return notImageProject;
    }

    private static Path readIndexPath() throws URISyntaxException {
        // target 目录 target/classes/
        URL classPath = IndexWriter.class.getResource("/");
        Path currentRoot = Paths.get(classPath.toURI()).getParent().getParent();
        return Paths.get(currentRoot.toString(), "index.html");
    }

}
