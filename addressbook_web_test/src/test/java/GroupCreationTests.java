import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        OpenGroupsPage();
        createGroup(new GroupData("Group name", "Group header", "Group footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        OpenGroupsPage();
        createGroup(new GroupData());
    }

    @Test
    public void CanCreateGroupNameOnly() {
        OpenGroupsPage();
        var emptyGroup = new GroupData();
        var GroupWithName = emptyGroup.withName("some name");
        createGroup(GroupWithName);
    }
}
