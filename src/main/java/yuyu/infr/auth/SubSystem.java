package yuyu.infr.auth;

/**
 * サブシステム型のインターフェースです。<br />
 * 機能をサブシステムID、サブシステム名、ソート番号の取得のみに限定しています。
 */
public interface SubSystem {
    public String getSubSystemId();
    public String getSubSystemNm();
    public Integer getSortNo();
}
