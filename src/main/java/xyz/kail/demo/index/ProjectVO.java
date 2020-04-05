package xyz.kail.demo.index;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * https://api.github.com/orgs/hello-world-example/repos?per_page=1000
 */
@Getter
@Setter
@ToString
public class ProjectVO {

    private String name;

    private String description;

    @JSONField(name = "full_name")
    private String fullName;

    @JSONField(name = "updated_at")
    private Date updatedAt;

    private String image;

}
