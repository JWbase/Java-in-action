package modernjavainaction.chap01.File;

import java.io.File;
import java.io.FileFilter;

public class file {

    File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isHidden(); // 숨겨진 파일 필터링
        }
    });

    /*
    위 코드는 file.isHidden 이라는 메소드가 이미 있는데 Fileter 로 감싼다음 FileFilter 를 인스턴스화 해야한다. 복잡함
    자바 8에서는 메소드 참조를 이용해서 간단히 구현 가능

    자바8부터는 메소드가 이급값이 아닌 일급값(매개변수로 전달가능)
    */

    File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);
}
