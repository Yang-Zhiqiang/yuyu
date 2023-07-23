package yuyu.infr.report.swakreport;

import java.util.Map;


/**
 * 書類属性情報読み込みクラスのインターフェースです。<br />
 * 書類属性情報読み込みクラスはこのインターフェースを実装する必要があります。
 */
public abstract class SyoruiZokuseiReader {
    public abstract Map<String, SyoruiZokusei> read();
}
