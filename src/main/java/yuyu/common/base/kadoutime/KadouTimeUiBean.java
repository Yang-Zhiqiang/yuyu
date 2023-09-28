package yuyu.common.base.kadoutime;

/**
 * 稼働時間uiBean拡張エンティティ
 * 「特定日稼働時間登録」と「稼働時間登録」機能のUiBeanが使用するインタフェースです。
 */
public interface KadouTimeUiBean {

    public void setKadouTime(KadouTime pKadouTime, int pIdx);

    public KadouTimeTableData getKadouTime();
}
