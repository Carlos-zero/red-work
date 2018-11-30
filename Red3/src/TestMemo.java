

public class TestMemo {


    public static void main(String[] args) throws Exception {

        ChooseDemo ch = new ChooseDemo();

        while (true) {
            ch.menu();
            int choose = ch.getInputIntInfo("<请输入数字选择操作>");
            ch.Choose(choose);
        }
    }
}