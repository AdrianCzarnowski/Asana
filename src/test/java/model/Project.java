package model;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Project {
    String gid;
    String resource_type;
    String name;

    public Project(String  gid, String resource_type, String name) {
        this.gid = gid;
        this.resource_type = resource_type;
        this.name = name;
    }
}
