package jar;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "usertable")
public class UserEntity {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private int userid;

    @Column
    private String userfamilyname;
    @Column
    private String usergivenname;
    @Column
    private String userprofession;

    public UserEntity() {

    }

    public UserEntity(int id, String userfamilyname, String usergivenname, String userprofession) {
        this.userid = id;
        this.userfamilyname = userfamilyname;
        this.usergivenname = usergivenname;
        this.userprofession = userprofession;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userid=" + userid +
                ", userfamilyname='" + userfamilyname + '\'' +
                ", usergivenname='" + usergivenname + '\'' +
                ", userprofession='" + userprofession + '\'' +
                '}';
    }
}
