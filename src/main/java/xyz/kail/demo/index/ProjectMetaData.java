package xyz.kail.demo.index;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 首页需要渲染的数据
 */
public class ProjectMetaData {

    private static final String API = "https://api.github.com/orgs/hello-world-example/repos?per_page=100";

    private static final Map<String, String> PROJECTS = new HashMap<>();

    static {
        PROJECTS.put("Algorithms", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3512040529,4233374958&fm=26&gp=0.jpg");
        PROJECTS.put("Apache-Commons", "http://commons.apache.org/images/commons-logo.png");
        PROJECTS.put("Architecture", "http://img3.imgtn.bdimg.com/it/u=3039734467,340032026&fm=26&gp=0.jpg");
        PROJECTS.put("Docker", "http://img4.imgtn.bdimg.com/it/u=1037767819,3957627469&fm=26&gp=0.jpg");
        PROJECTS.put("Dubbo", "http://img2.imgtn.bdimg.com/it/u=2972985774,2683216584&fm=26&gp=0.jpg");
        PROJECTS.put("ECMAScript", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1581698897795&di=c80481c87d626e05525c9301ad33f13d&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fq_mini%2Cc_zoom%2Cw_640%2Fimages%2F20171111%2Facb4a7d5b5a94186b103a23b9b61ff7b.jpg");
        PROJECTS.put("ElasticSearch", "http://img3.imgtn.bdimg.com/it/u=1062140215,59502734&fm=26&gp=0.jpg");
        PROJECTS.put("Apache-Flink", "http://img4.imgtn.bdimg.com/it/u=491608498,208888278&fm=26&gp=0.jpg");
        PROJECTS.put("FreeMarker", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2725454846,1665261921&fm=26&gp=0.jpg");
        PROJECTS.put("Git", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=301239496,3533152787&fm=26&gp=0.jpg");
        PROJECTS.put("Guava", "http://img1.imgtn.bdimg.com/it/u=2187732913,144603690&fm=26&gp=0.jpg");
        PROJECTS.put("Hadoop", "http://img5.imgtn.bdimg.com/it/u=1237104594,4115763057&fm=26&gp=0.jpg");
        PROJECTS.put("HAProxy", "http://img4.imgtn.bdimg.com/it/u=2299960945,1621205625&fm=26&gp=0.jpg");
        PROJECTS.put("HBase", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1581699023243&di=b894e31248b506ea968dcfa45885178a&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D2031839447%2C2936977722%26fm%3D214%26gp%3D0.jpg");
        PROJECTS.put("Java", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573304467632&di=75bd40dedc7b361243d6e3e5cd993637&imgtype=0&src=http%3A%2F%2Fs15.sinaimg.cn%2Fmw690%2F006UXnVgzy7hOeKADjo4e%26690");
        PROJECTS.put("Java-Concurrent", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582221507736&di=58001d2737690b2c1d89c232bbba957a&imgtype=0&src=http%3A%2F%2Ffinance.people.com.cn%2FNMediaFile%2F2015%2F0929%2FMAIN201509290905444537505693475.jpg");
        PROJECTS.put("Java-IO", "http://img5.imgtn.bdimg.com/it/u=431714666,3598119687&fm=26&gp=0.jpg");
        PROJECTS.put("JavaScript", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1581699073866&di=d42debd30ed1acc725fa3a51903f2eb5&imgtype=0&src=http%3A%2F%2Fbpic.588ku.com%2Felement_origin_min_pic%2F00%2F85%2F77%2F1956e9e3afe5091.jpg");
        PROJECTS.put("Kafka", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573315426586&di=6c3c8984607d44e3cb588ccb4ca95817&imgtype=0&src=http%3A%2F%2Fwww.instaclustr.com%2Fwp-content%2Fuploads%2F2017%2F05%2Fapache-kafka-640x640.png");
        PROJECTS.put("Keepalived", "http://img3.imgtn.bdimg.com/it/u=1975073058,3087983341&fm=26&gp=0.jpg");
        PROJECTS.put("Leader", "http://img3.imgtn.bdimg.com/it/u=797992881,3602554816&fm=26&gp=0.jpg");
        PROJECTS.put("Linux", "http://img3.imgtn.bdimg.com/it/u=190342927,1537631978&fm=26&gp=0.jpg");
        PROJECTS.put("Maven", "http://img4.imgtn.bdimg.com/it/u=1006881512,4045403874&fm=26&gp=0.jpg");
        PROJECTS.put("Mock", "http://img1.imgtn.bdimg.com/it/u=213228134,794964317&fm=26&gp=0.jpg");
        PROJECTS.put("MySQL", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1581699176975&di=6a570f93f1fcf1b894cb0d8676fcbef4&imgtype=0&src=http%3A%2F%2Fp6.qhimg.com%2Ft0120e5a5d29de58149.jpg");
        PROJECTS.put("Network", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1581699235529&di=060ccb3b50304ddb7bf3157d3439bf3a&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F350d9ab7464880245dcd1a7eea6a8d8ab7ef6b515422b-NUtuOc_fw658");
        PROJECTS.put("Nginx", "http://img4.imgtn.bdimg.com/it/u=3449496352,2315970436&fm=26&gp=0.jpg");
        PROJECTS.put("PostgreSQL", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=607807026,1711629498&fm=26&gp=0.jpg");
        PROJECTS.put("ProtoBuf", "http://img1.imgtn.bdimg.com/it/u=2593208106,2060488427&fm=26&gp=0.jpg");
        PROJECTS.put("Python", "http://img3.imgtn.bdimg.com/it/u=4026449047,2644868388&fm=26&gp=0.jpg");
        PROJECTS.put("RabbitMQ", "http://img1.imgtn.bdimg.com/it/u=2055190456,3669890347&fm=26&gp=0.jpg");
        PROJECTS.put("Redis", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3415617548,1216693599&fm=26&gp=0.jpg");
        PROJECTS.put("RocketMQ", "http://img5.imgtn.bdimg.com/it/u=4099551539,2550907312&fm=26&gp=0.jpg");
        PROJECTS.put("Reactor", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2796307513,889748421&fm=26&gp=0.jpg");
        PROJECTS.put("Research", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2034882606,388144644&fm=26&gp=0.jpg");
        PROJECTS.put("Solr", "http://img2.imgtn.bdimg.com/it/u=4207341731,1016545429&fm=26&gp=0.jpg");
        PROJECTS.put("Spring", "http://img4.imgtn.bdimg.com/it/u=2995354372,2168828254&fm=26&gp=0.jpg");
        PROJECTS.put("Spring-Boot", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2331877823,2031479521&fm=26&gp=0.jpg");
        PROJECTS.put("Spring-Cloud", "https://i0.wp.com/e4developer.com/wp-content/uploads/2018/01/spring-cloud-logo.png?resize=800%2C753&ssl=1");
        PROJECTS.put("TFS", "http://img3.imgtn.bdimg.com/it/u=3199094886,4165035157&fm=26&gp=0.jpg");
        PROJECTS.put("TensorFlow", "http://img4.imgtn.bdimg.com/it/u=4180865175,1235989499&fm=26&gp=0.jpg");
        PROJECTS.put("Troubleshooting", "http://img4.imgtn.bdimg.com/it/u=1543094388,4252010312&fm=26&gp=0.jpg");
        PROJECTS.put("Zookeeper", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2045816738,684672730&fm=26&gp=0.jpg");
    }

    public static List<ProjectVO> readProjects() throws IOException {

        // 从 Github api 读取数据
        String json = Jsoup.connect(API)
                .timeout(10_000)
                .ignoreContentType(true)
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36 Edg/80.0.361.69")
                .get()
                .body()
                .text();

        // 解析 json 成对象
        List<ProjectVO> projectVOS = JSON.parseArray(json, ProjectVO.class);

        // 格式处理
        return projectVOS.stream()
                // 填充图片
                .peek(p -> p.setImage(PROJECTS.get(p.getName())))
                // 更新时间倒序
                .sorted(Comparator.comparing(ProjectVO::getUpdatedAt).reversed())
                .collect(Collectors.toList());
    }

}
