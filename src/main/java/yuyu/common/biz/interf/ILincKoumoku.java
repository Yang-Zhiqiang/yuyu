package yuyu.common.biz.interf;

/**
 * 業務共通 インターフェイス LINC項目定義
 */
public interface ILincKoumoku {

    public static final int LINC_DATAKBN_HDRECORD= 1;

    public static final int LINC_DATAKBN_TRRECORD= 8;

    public static final int LINC_DATAKBN_ENDRECORD= 9;

    public static final int LINC_DARAKBN_DATARECORD= 2;

    public static final int LINC_GYOMUSYUBETU_KYKNYTRK= 87;

    public static final int LINC_CODEKBN_JIS= 0;

    public static final int LINC_CODEKBN_EBCDIC= 1;

    public static final int LINC_DATASYUBETU_SOJUSIN01= 1;

    public static final int LINC_DATASYUBETU_SOJUSIN02= 2;

    public static final int LINC_DATASYUBETU_KRKS01= 11;

    public static final int LINC_DATASYUBETU_KRKS02= 12;

    public static final int LINC_KAITOUSOSA_TUUJOU= 0;

    public static final int LINC_KAITOUSOSA_YOKUJITU= 1;

    public static final int LINC_SYUSINDATA_01= 1;

    public static final int LINC_SYUSINDATA_02= 2;

    public static final int LINC_RECORD_TRKHENKOMD_KYHHK= 1;

    public static final int LINC_RECORD_TRKHENKOKT_KYH= 2;

    public static final int LINC_RECORD_SRTSYUMD_KYHHKKT= 3;

    public static final int LINC_RECORD_SRTSYUKT_KYH= 4;

    public static final int LINC_RECORD_SKYKSYK_KYHHKKT= 5;

    public static final int LINC_RECORD_SKYKKT_KYH= 6;

    public static final int LINC_RECORD_SKYKNYS_KYH= 7;

    public static final int LINC_RECORD_TRKSYK_KYH= 8;

    public static final int LINC_RECORD_TRKKT_KYH= 9;

    public static final int LINC_RECORD_TRKNYS_KYH= 10;

    public static final int LINC_RECORD_TRKHENKOMDSJ_HK= 11;

    public static final int LINC_RECORD_TRKHENKOKT_HK= 12;

    public static final int LINC_RECORD_SRTSYUKT_HK= 14;

    public static final int LINC_RECORD_SKYKKT_HK= 16;

    public static final int LINC_RECORD_SKYKNYS_HK= 17;

    public static final int LINC_RECORD_TRKSYK_HK= 18;

    public static final int LINC_RECORD_TRKKT_HK= 19;

    public static final int LINC_RECORD_TRKNYS_HK= 20;

    public static final int LINC_RECORD_TRKHENKOMD_KYT= 21;

    public static final int LINC_RECORD_TRKHENKOKT_KYT=22;

    public static final int LINC_RECORD_SRTSYUKT_KYT= 24;

    public static final int LINC_RECORD_SKYKKT_KYT= 26;

    public static final int LINC_RECORD_SKYKNYS27_KYT= 27;

    public static final int LINC_RECORD_SKYKNYS37_KYT= 37;

    public static final int LINC_RECORD_HOZENSYK_KYHHKKT= 28;

    public static final int LINC_RECORD_HOZENSYKKT_KYHHKKT= 29;

    public static final int LINC_RECORD_HOZENSYKNYS_KYHHKKT= 30;

    public static final int LINC_RECORD_HOZENSRTMD_KYHHKKT= 31;

    public static final int LINC_RECORD_HOZENHSRT_KYHHKKT= 32;

    public static final int LINC_RECORD_HOZENSYRKT_KYHHKKT= 33;

    public static final int LINC_RECORD_TRKHENKOMD_MD= 40;

    public static final int LINC_RECORD_TRKHENKOKT_MD= 41;

    public static final int LINC_RECORD_TRKHENKOMD_JH= 42;

    public static final int LINC_RECORD_TRKHENKOKT_JH= 43;

    public static final int LINC_RECORD_TRKHENKOMD_TK= 44;

    public static final int LINC_RECORD_TRKHENKOKT_TK= 45;

    public static final int LINC_RECORD_SKYKNYS_MDJHTK= 50;

    public static final int LINC_RECORD_SKYKNYSTUTI_MDJHTK= 51;

    public static final int LINC_RECORD_HOZENNYS_MDJHTK= 60;

    public static final int LINC_RECORD_HOZENNYSTUTI_MDJHTK= 61;

    public static final String LINC_HENKOTYPE_HUYOU= " ";

    public static final String LINC_HENKOTYPE_TUIKA= "I";

    public static final String LINC_HENKOTYPE_SAKUJO= "D";

    public static final String LINC_HENKOTYPE_OKIKAE= "U";

    public static final int LINC_SYORI_CODE_0= 0;

    public static final int LINC_SYORI_CODE_SEIJO= 1;

    public static final int LINC_SYORI_CODE_SEIJONYS= 2;

    public static final int LINC_SYORI_CODE_SEIJONYSMD= 3;

    public static final int LINC_SYORI_CODE_SEIJONYSJGHK= 4;

    public static final int LINC_SYORI_CODE_SEIJONYSMDJGHK= 5;

    public static final int LINC_SYORI_CODE_SEIJOWERNING= 8;

    public static final int LINC_SYORI_CODE_ERROR= 9;

    public static final int LINC_SYORI_JIYU_SEIJO= 0;

    public static final int LINC_SYORI_JIYU_DATAERROR= 1;

    public static final int LINC_SYORI_JIYU_CROSSERROR= 2;

    public static final int LINC_SYORI_JIYU_NORECORDNONE= 3;

    public static final int LINC_SYORI_JIYU_CODESOUI= 4;

    public static final int LINC_SYORI_JIYU_SYSTRK= 81;

    public static final int LINC_SYORI_JIYU_TRKHENKO= 82;

    public static final int LINC_SYORI_JIYU_HEADERERROR= 99;

    public static final int LINC_NYSKEY_HHKNSEIBETU_OTOKO= 1;

    public static final int LINC_NYSKEY_HHKNSEIBETU_ONNA= 2;

    public static final int LINC_NYSKEY_HHKNSEIBETU_SYSMAE= 3;

    public static final int LINC_KEIHIDJ_IJIN= 0;

    public static final int LINC_KEIHIDJN_DJN= 1;

    public static final int LINC_MDFLG_NONE= 0;

    public static final int LINC_MDFLG_ARI= 1;

    public static final int LINC_JGYHKNFLG_HKNIGAI= 0;

    public static final int LINC_JGYHKNFLG_HKN= 1;

    public static final int LINC_TKFLG_KYKIGAI= 0;

    public static final int LINC_TKFLG_KYK= 1;

    public static final int LINC_KYKSEIBETU_OTOKO= 1;

    public static final int LINC_KYKSEIBETU_ONNA= 2;

    public static final int LINC_KYKSEIBETU_HOUJIN= 3;

    public static final int LINC_MIMANTYOUFLG_HIGAITO= 0;

    public static final int LINC_MIMANTYOUFLG_GAITO= 1;

    public static final int LINC_KANJIFLG_HIGAITO= 0;

    public static final int LINC_KANJIFLG_ARI= 1;

    public static final int LINC_SKNMNJCD_NONE= 0;

    public static final int LINC_SKNMNJCD_ARI= 1;

    public static final int LINC_SKNMNJCD_KIGOUKAKU= 2;

    public static final int LINC_BSEIBETU_OTOKO= 1;

    public static final int LINC_BSEIBETU_ONNA= 2;

    public static final int LINC_SYOKSYKBNCD_NAIKIN= 10;

    public static final int LINC_SYOKSYKBNCD_EIGYOU= 20;

    public static final int LINC_SYOKSYKBNCD_KJNDRTEN= 32;

    public static final int LINC_SYOKSYKBNCD_KJNSIYOU= 33;

    public static final int LINC_SYOKSYKBNCD_HJNDRTN= 40;

    public static final int LINC_SYOKSYKBNCD_HJNJIM= 41;

    public static final int LINC_SYOKSYKBNCD_HJNDAIHYOU= 42;

    public static final int LINC_SYOKSYKBNCD_HJNSIYOU= 43;
}
