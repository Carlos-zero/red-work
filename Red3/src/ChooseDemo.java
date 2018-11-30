import java.util.Scanner;

public class ChooseDemo {

    /*
     *得到int类型的数据,这个和下面String判断数据类型网上搬运的。。。
     */
    public int getInputIntInfo(String info) {
        int input_int = 0;
        try {
            System.out.println(info);
           Scanner s = new Scanner(System.in);
           input_int = s.nextInt();
       } catch (Exception e) {
           System.out.println("输入错误！！请重新输入。");
            input_int = getInputIntInfo(info);
        }
        return input_int;

    }

    /*
     *得到String类型的数据
     */
    public String getInputStringInfo(String string) {
       String input_String = "";
        try {
            System.out.println(string);
            Scanner s = new Scanner(System.in);
            input_String = s.next();
        } catch (Exception e) {
            System.out.println("输入错误！！请重新输入");
            input_String = getInputStringInfo(string);
       }
        return input_String;   }

    public void menu() {
        System.out.println("************************");
        System.out.println("欢迎进入学生信息管理系统");
        System.out.println("1.添加学生信息");
        System.out.println("2.修改学生信息（根据学号修改）");
        System.out.println("3.删除学生信息(根据学号删除)");
        System.out.println("4.查询所有学生信息");
        System.out.println("5.升序降序排序");
        System.out.println("6.退出系统");
        System.out.println("************************");
    }

    public void Choose(int coad) throws Exception {
        switch (coad) {
            //添加学生信息if语句搬运书上图书馆系统
            case 1:
                System.out.println("<---你已进入添加学生信息界面--->");

                Info add_info = getStudentInfo();
                if (!(Handle.selectStuId(add_info.getStu_id()))) {
                    if (Handle.AddInfo(add_info)) {
                        System.out.println("\n添加成功！！\n");
                    } else {
                        System.out.println("\n添加失败！！\n");
                    }
                } else {
                    System.out.println("该学号已存在！！！	请重新添加！！");
                }
                break;
            //修改学生信息（根据学号修改）
            case 2:
                System.out.println("<---你已进入修改学生信息（根据学号修改）界面--->");

                int update_id = getInputIntInfo("请输入学号");

                if (Handle.selectStuId(update_id)) {
                    System.out.println("<---请输入新的学生信息--->");
                    Info update_infoById = getStudentInfo();
                    if (!(Handle.selectStuId(update_infoById.getStu_id())) || update_infoById.getStu_id() == update_id) {
                        if (Handle.updateInfoById(update_id, update_infoById)) {
                            System.out.println("\n修改成功！！！\n");
                        } else {
                            System.out.println("\n修改失败！！！\n");
                        }
                    } else {
                        System.out.println("该学号的学生信息已存在！！！	请重新添加！！");
                    }
                } else {
                    System.out.println("\n没有该学号的学生信息！！请重新选择！\n");
                }
                break;


            case 3:
                System.out.println("<---你已进入删除学生信息(根据学号删除)界面--->");
                int delete_id = getInputIntInfo("请输入学号");

                if (Handle.selectStuId(delete_id)) {
                    if (Handle.deleteInfoById(delete_id)) {
                        System.out.println("\n删除成功！！！\n");
                    } else {
                        System.out.println("\n删除失败！！！\n");
                    }
                } else {
                    System.out.println("\n没有该学号的学生信息！！请重新选择！\n");
                }
                break;

            //查询所有学生信息
            case 4:
                System.out.println("<---你已进入所有学生信息界面--->");
                Handle.selectAllInfo();
                break;

            case 5:
                System.out.println("<---开始降序排序--->");
                Handle.sortjx();
                break;


            case 6:
                System.out.println("退出成功！");
                System.exit(0);
                break;
            default:
                System.out.println("没有该选项！！请重新输入！");
                break;
        }
    }

    //给 Info类的学生属性进行赋值
    private Info getStudentInfo() {
        Info info = new Info();

        info.setStu_id(getInputIntInfo("请输入学号"));
        info.setStu_name(getInputStringInfo("请输入姓名"));
        info.setStu_sex(getInputStringInfo("请输入性别"));
        info.setStu_age(getInputIntInfo("请输入年龄"));
        info.setClasses(getInputIntInfo("请输入班级"));

        return info;

    }
}