import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class GroupRemovalTests extends TestBase {


    @Test
    public void canRemoveGroup()
    {
        if (isGroupPresent("new")) {
            driver.findElement(By.linkText("groups")).click();
        }
        if (isGroupPresent("selected[]")){
            createGroup(new GroupData("Group name", "Group header", "Group footer"));

        }
        removeGroup();
    }


}
