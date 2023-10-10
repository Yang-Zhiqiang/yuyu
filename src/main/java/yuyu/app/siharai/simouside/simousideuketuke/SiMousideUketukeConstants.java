package yuyu.app.siharai.simouside.simousideuketuke;

import yuyu.def.classification.C_Kouteikanristatus;

/**
 * 申出受付 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SiMousideUketukeConstants extends GenSiMousideUketukeConstants {

    public static final String SYO_TTDKANNAISKI      = "SyoTtdkAnnaiSki";

    public static final String SYO_HKNKMOSUKE        = "SyoHknkMosUke";

    public static final String PANKUZU_TTDKANNAISKI  = "手続案内照会";

    public static final String PANKUZU_HKNKMOSUKE    = "保険金申出受付";

    static final int    CNT_KYKKIHON_MAIN     = 0;

    static final int    PDFSOURCE_TBL           = 0;

    static final int    PDFSOURCE_KOTEIPDF      = 1;

    static final int    PDFSOURCE_TBL_KOTEIPDF  = 2;

    static final C_Kouteikanristatus[] KOUTEIKANRISTATUS_SYORITYUU_KANRYOU = { C_Kouteikanristatus.SYORITYUU,
        C_Kouteikanristatus.KANRYOU };

}
