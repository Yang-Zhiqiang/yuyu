package yuyu.app.direct.dskokyakukanri.dskokyakuseibi;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 顧客整備 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenDsKokyakuSeibiConstants {

    public static final int PAGENO_INIT                     = 1;

    public static final int PAGENO_SELECTSYORI              = 1;

    public static final int PAGENO_INPUTKEYSELECT           = 2;

    public static final int PAGENO_SEIBITSSEARCH            = 3;

    public static final int PAGENO_INPUTCONTENTS            = 4;

    public static final int PAGENO_CONFIRM                  = 5;

    public static final int PAGENO_RESULT                   = 6;

    public static final int PAGENO_KYKBTINPUTCONTENTS       = 7;

    public static final int PAGENO_KYKBTCONFIRM             = 8;

    public static final int PAGENO_KYKBTRESULT              = 9;

    public static final int PAGENO_TKTITRHKYUKOUZASEARCH    = 10;

    static final String FORWARDNAME_INIT                     = "init";

    static final String FORWARDNAME_CURRENT                  = "current";

    static final String FORWARDNAME_SELECTSYORI              = "SelectSyori";

    static final String FORWARDNAME_INPUTKEYSELECT           = "InputKeySelect";

    static final String FORWARDNAME_SEIBITSSEARCH            = "SeibitsSearch";

    static final String FORWARDNAME_INPUTCONTENTS            = "InputContents";

    static final String FORWARDNAME_CONFIRM                  = "Confirm";

    static final String FORWARDNAME_RESULT                   = "Result";

    static final String FORWARDNAME_KYKBTINPUTCONTENTS       = "KykbtInputContents";

    static final String FORWARDNAME_KYKBTCONFIRM             = "KykbtConfirm";

    static final String FORWARDNAME_KYKBTRESULT              = "KykbtResult";

    static final String FORWARDNAME_TKTITRHKYUKOUZASEARCH    = "TktiTrhkyuKouzaSearch";

    static final String FORWARDNAME_GOTODSTRHKSERVICETOUROKU = "gotoDsTrhkServiceTouroku";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("dskokyakuseibi", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SRCHDSKOKNOINFO_SRCHDSKOKNO = new Item("dskokyakuseibi", "srchdskoknoInfo", "srchdskokno", null, ErrorMsgKbn.DD);

    static final Item DDID_SRCHSYONOINFO_SRCHSYONO = new Item("dskokyakuseibi", "srchsyonoInfo", "srchsyono", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOKINFO_SRCHDSKOKYAKUNMKJ = new Item("dskokyakuseibi", "kokInfo", "srchdskokyakunmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_KOKINFO_SRCHDSKOKYAKUNMKN = new Item("dskokyakuseibi", "kokInfo", "srchdskokyakunmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_KOKINFO_SRCHDSKOKYAKUSEIYMD = new Item("dskokyakuseibi", "kokInfo", "srchdskokyakuseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KOKINFO_SRCHDSKOKYAKUYNO = new Item("dskokyakuseibi", "kokInfo", "srchdskokyakuyno", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHJYOUKENINFO_SYORIYMDFROM = new Item("dskokyakuseibi", "searchjyoukenInfo", "syoriYmdFrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHJYOUKENINFO_SYORIYMDTO = new Item("dskokyakuseibi", "searchjyoukenInfo", "syoriYmdTo", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHJYOUKENKOUZAINFO_SRCHTKTITRHKKZBANKCD = new Item("dskokyakuseibi", "searchjyoukenKouzaInfo", "srchtktitrhkkzbankcd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHJYOUKENKOUZAINFO_SRCHTKTITRHKKZSITENCD = new Item("dskokyakuseibi", "searchjyoukenKouzaInfo", "srchtktitrhkkzsitencd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHJYOUKENKOUZAINFO_SRCHHAISIYMDFROM = new Item("dskokyakuseibi", "searchjyoukenKouzaInfo", "srchhaisiymdfrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHJYOUKENKOUZAINFO_SRCHHAISIYMDTO = new Item("dskokyakuseibi", "searchjyoukenKouzaInfo", "srchhaisiymdto", null, ErrorMsgKbn.ERROR);

    static final Item DDID_HEADERBUTTONS1_CLEARBTNBYINPUTKEYSELECT = new Item("dskokyakuseibi", "headerButtons1", "clearbtnbyinputkeyselect", null, ErrorMsgKbn.DD);

    static final Item DDID_HEADERBUTTONS2_CLEARBTNBYSEIBITSSEARCH = new Item("dskokyakuseibi", "headerButtons2", "clearbtnbyseibitssearch", null, ErrorMsgKbn.DD);

    static final Item DDID_HEADERBUTTONS3_CLEARBTNBYTKTITRHKKZ = new Item("dskokyakuseibi", "headerButtons3", "clearbtnbytktitrhkkz", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_DSKOKNO = new Item("dskokyakuseibi", "searchResultInfo", "dskokno", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_SYONO = new Item("dskokyakuseibi", "searchResultInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_DSKOKYAKUNMKJ = new Item("dskokyakuseibi", "searchResultInfo", "dskokyakunmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_DSKOKYAKUSEIYMD = new Item("dskokyakuseibi", "searchResultInfo", "dskokyakuseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_DSKOKYAKUJTKBN = new Item("dskokyakuseibi", "searchResultInfo", "dskokyakujtkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_PASSWORDJTKBN = new Item("dskokyakuseibi", "searchResultInfo", "passwordjtkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_SEIBIRIYUUKBN = new Item("dskokyakuseibi", "searchResultInfo", "seibiriyuukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_SYORIYMD = new Item("dskokyakuseibi", "searchResultInfo", "syoriYmd", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_SYORIZUMIFLG = new Item("dskokyakuseibi", "searchResultInfo", "syorizumiflg", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_DSKOKYAKUNMKN = new Item("dskokyakuseibi", "searchResultInfo", "dskokyakunmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_DSKOKYAKUYNO = new Item("dskokyakuseibi", "searchResultInfo", "dskokyakuyno", null, ErrorMsgKbn.DD);

    static final Item DDID_SRCHRSLTKZINFO_DISPBANKCD = new Item("dskokyakuseibi", "srchRsltKzInfo", "dispbankcd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SRCHRSLTKZINFO_DISPBANKNMKJ = new Item("dskokyakuseibi", "srchRsltKzInfo", "dispbanknmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_SRCHRSLTKZINFO_SINSETUYMD = new Item("dskokyakuseibi", "srchRsltKzInfo", "sinsetuymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SRCHRSLTKZINFO_DISPKOUZANO = new Item("dskokyakuseibi", "srchRsltKzInfo", "dispkouzano", null, ErrorMsgKbn.DISP);

    static final Item DDID_SRCHRSLTKZINFO_DISPKYKNMKN = new Item("dskokyakuseibi", "srchRsltKzInfo", "dispkyknmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SRCHRSLTKZINFO_DSKOKNO = new Item("dskokyakuseibi", "srchRsltKzInfo", "dskokno", null, ErrorMsgKbn.DD);

    static final Item DDID_SRCHRSLTKZINFO_SYONO = new Item("dskokyakuseibi", "srchRsltKzInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_SRCHRSLTKZINFO_DISPSITENCD = new Item("dskokyakuseibi", "srchRsltKzInfo", "dispsitencd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SRCHRSLTKZINFO_DISPSITENNMKJ = new Item("dskokyakuseibi", "srchRsltKzInfo", "dispsitennmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_SRCHRSLTKZINFO_HAISIYMD = new Item("dskokyakuseibi", "srchRsltKzInfo", "haisiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SRCHRSLTKZINFO_DISPKZMEIGINMKN = new Item("dskokyakuseibi", "srchRsltKzInfo", "dispkzmeiginmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOZENINFO_KYKNMKJ = new Item("dskokyakuseibi", "hozenInfo", "kyknmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_HOZENINFO_KYKNMKN = new Item("dskokyakuseibi", "hozenInfo", "kyknmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOZENINFO_KYKSEIYMD = new Item("dskokyakuseibi", "hozenInfo", "kykseiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOZENINFO_TSINYNO = new Item("dskokyakuseibi", "hozenInfo", "tsinyno", null, ErrorMsgKbn.DD);

    static final Item DDID_HOZENINFO_KYKSEI = new Item("dskokyakuseibi", "hozenInfo", "kyksei", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOZENINFO_TSINADR1KJ = new Item("dskokyakuseibi", "hozenInfo", "tsinadr1kj", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOZENINFO_TSINADR2KJ = new Item("dskokyakuseibi", "hozenInfo", "tsinadr2kj", null, ErrorMsgKbn.DD);

    static final Item DDID_HOZENINFO_TSINADR3KJ = new Item("dskokyakuseibi", "hozenInfo", "tsinadr3kj", null, ErrorMsgKbn.DD);

    static final Item DDID_HOZENINFO_TSINTELNO = new Item("dskokyakuseibi", "hozenInfo", "tsintelno", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOZENINFO_DAI2TSINTELNO = new Item("dskokyakuseibi", "hozenInfo", "dai2tsintelno", null, ErrorMsgKbn.DISP);

    static final Item DDID_DRCTSERVICEINFO_DSKOKYAKUNMKJ = new Item("dskokyakuseibi", "drctserviceInfo", "dskokyakunmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_DRCTSERVICEINFO_DSKOKYAKUNMKN = new Item("dskokyakuseibi", "drctserviceInfo", "dskokyakunmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_DRCTSERVICEINFO_DSKOKYAKUSEIYMD = new Item("dskokyakuseibi", "drctserviceInfo", "dskokyakuseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_DRCTSERVICEINFO_DSKOKYAKUYNO = new Item("dskokyakuseibi", "drctserviceInfo", "dskokyakuyno", null, ErrorMsgKbn.DD);

    static final Item DDID_DRCTSERVICEINFO1_INPUTDSKOKYAKUNMKJ = new Item("dskokyakuseibi", "drctserviceInfo1", "inputdskokyakunmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_DRCTSERVICEINFO1_INPUTDSKOKYAKUNMKN = new Item("dskokyakuseibi", "drctserviceInfo1", "inputdskokyakunmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_DRCTSERVICEINFO1_INPUTDSKOKYAKUSEIYMD = new Item("dskokyakuseibi", "drctserviceInfo1", "inputdskokyakuseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_DRCTSERVICEINFO1_INPUTDSKOKYAKUYNO = new Item("dskokyakuseibi", "drctserviceInfo1", "inputdskokyakuyno", null, ErrorMsgKbn.DD);

    static final Item DDID_DRCTSERVICEINFO2_KAKUNINDSKOKYAKUNMKJ = new Item("dskokyakuseibi", "drctserviceInfo2", "kakunindskokyakunmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_DRCTSERVICEINFO2_KAKUNINDSKOKYAKUNMKN = new Item("dskokyakuseibi", "drctserviceInfo2", "kakunindskokyakunmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_DRCTSERVICEINFO2_KAKUNINDSKOKYAKUSEIYMD = new Item("dskokyakuseibi", "drctserviceInfo2", "kakunindskokyakuseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_DRCTSERVICEINFO2_KAKUNINDSKOKYAKUYNO = new Item("dskokyakuseibi", "drctserviceInfo2", "kakunindskokyakuyno", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJTINFO_DSKOKNO = new Item("dskokyakuseibi", "dskokyakujtInfo", "dskokno", null, ErrorMsgKbn.DISP);

    static final Item DDID_DSKOKYAKUJTINFO_DSKOKYAKUJTKBN = new Item("dskokyakuseibi", "dskokyakujtInfo", "dskokyakujtkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJTINFO_KAKUNINDSKOKYAKUJTKBN = new Item("dskokyakuseibi", "dskokyakujtInfo", "kakunindskokyakujtkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJTINFO_DSKOKYAKUSAKUSEIYMD = new Item("dskokyakuseibi", "dskokyakujtInfo", "dskokyakusakuseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJTINFO_DSTEISIRIYUUKBN = new Item("dskokyakuseibi", "dskokyakujtInfo", "dsteisiriyuukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJTINFO_INPUTDSTEISIRIYUUKBN = new Item("dskokyakuseibi", "dskokyakujtInfo", "inputdsteisiriyuukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJTINFO_KAKUNINDSTEISIRIYUUKBN = new Item("dskokyakuseibi", "dskokyakujtInfo", "kakunindsteisiriyuukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJTINFO_DSKOKYAKUMUKOUYMD = new Item("dskokyakuseibi", "dskokyakujtInfo", "dskokyakumukouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJTINFO_KAKUNINDSKOKYAKUMUKOUYMD = new Item("dskokyakuseibi", "dskokyakujtInfo", "kakunindskokyakumukouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJTINFO_DSKANYUUKEIROKBN = new Item("dskokyakuseibi", "dskokyakujtInfo", "dskanyuukeirokbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJTINFO_INPUTDSKANYUUKEIROKBN = new Item("dskokyakuseibi", "dskokyakujtInfo", "inputdskanyuukeirokbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJTINFO_KAKUNINDSKANYUUKEIROKBN = new Item("dskokyakuseibi", "dskokyakujtInfo", "kakunindskanyuukeirokbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KRPASSWORDINFO_KRPASSWORDUMUKBN = new Item("dskokyakuseibi", "krpasswordInfo", "krpasswordumukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KRPASSWORDINFO_KAKUNINKRPASSWORDUMUKBN = new Item("dskokyakuseibi", "krpasswordInfo", "kakuninkrpasswordumukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KRPASSWORDINFO_DSKRHNNKAKCDSETKBN = new Item("dskokyakuseibi", "krpasswordInfo", "dskrhnnkakcdsetkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KRPASSWORDINFO_KAKUNINDSKRHNNKAKCDSETKBN = new Item("dskokyakuseibi", "krpasswordInfo", "kakunindskrhnnkakcdsetkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KRPASSWORDINFO_DSKRHNNKAKCDSETYMD = new Item("dskokyakuseibi", "krpasswordInfo", "dskrhnnkakcdsetymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KRPASSWORDINFO_KAKUNINDSKRHNNKAKCDSETYMD = new Item("dskokyakuseibi", "krpasswordInfo", "kakunindskrhnnkakcdsetymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KRPASSWORDINFO_DSKRHNNKAKCDYUUKOUYMD = new Item("dskokyakuseibi", "krpasswordInfo", "dskrhnnkakcdyuukouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KRPASSWORDINFO_KAKUNINDSKRHNNKAKCDYKYMD = new Item("dskokyakuseibi", "krpasswordInfo", "kakunindskrhnnkakcdykymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KRPASSWORDINFO_DSKRHNNKAKCDTTSHJYHSYMD = new Item("dskokyakuseibi", "krpasswordInfo", "dskrhnnkakcdttshjyhsymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KRPASSWORDINFO_KAKUNINDSKRHNNKAKCDTTJYYMD = new Item("dskokyakuseibi", "krpasswordInfo", "kakunindskrhnnkakcdttjyymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KRPASSWORDINFO_DSKRHNNKAKCDTTYHKBN = new Item("dskokyakuseibi", "krpasswordInfo", "dskrhnnkakcdttyhkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KRPASSWORDINFO_INPUTDSKRHNNKAKCDTTYHKBN = new Item("dskokyakuseibi", "krpasswordInfo", "inputdskrhnnkakcdttyhkbn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_KRPASSWORDINFO_KAKUNINDSKRHNNKAKCDTTYHKBN = new Item("dskokyakuseibi", "krpasswordInfo", "kakunindskrhnnkakcdttyhkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HONPASSWORDINFO_HONPASSWORDUMUKBN = new Item("dskokyakuseibi", "honpasswordInfo", "honpasswordumukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HONPASSWORDINFO_KAKUNINHONPASSWORDUMUKBN = new Item("dskokyakuseibi", "honpasswordInfo", "kakuninhonpasswordumukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HONPASSWORDINFO_DSHNNKAKCDSETYMD = new Item("dskokyakuseibi", "honpasswordInfo", "dshnnkakcdsetymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HONPASSWORDINFO_KAKUNINDSHNNKAKCDSETYMD = new Item("dskokyakuseibi", "honpasswordInfo", "kakunindshnnkakcdsetymd", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_SYOKAILOGINYMD = new Item("dskokyakuseibi", "loginInfo", "syokailoginymd", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_DISPSYOKAILOGINTIME = new Item("dskokyakuseibi", "loginInfo", "dispsyokailogintime", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_SYOKAILOGINBAITAIKBN = new Item("dskokyakuseibi", "loginInfo", "syokailoginbaitaikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_SAISINLOGINYMD = new Item("dskokyakuseibi", "loginInfo", "saisinloginymd", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_DISPSAISINLOGINTIME = new Item("dskokyakuseibi", "loginInfo", "dispsaisinlogintime", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_SAISINLOGINBAITAIKBN = new Item("dskokyakuseibi", "loginInfo", "saisinloginbaitaikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_DSHNNKAKCDERRORKAISUU = new Item("dskokyakuseibi", "loginInfo", "dshnnkakcderrorkaisuu", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_KAKUNINDSHNNKAKCDERRKAISUU = new Item("dskokyakuseibi", "loginInfo", "kakunindshnnkakcderrkaisuu", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_DSKOKYAKUNMERRORKAISUU = new Item("dskokyakuseibi", "loginInfo", "dskokyakunmerrorkaisuu", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_KAKUNINDSKOKNMERRKAISUU = new Item("dskokyakuseibi", "loginInfo", "kakunindskoknmerrkaisuu", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_DSKOKYAKUSEIYMDERRORKAISUU = new Item("dskokyakuseibi", "loginInfo", "dskokyakuseiymderrorkaisuu", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_KAKUNINDSKOKSEIYMDERRKAISUU = new Item("dskokyakuseibi", "loginInfo", "kakunindskokseiymderrkaisuu", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_DSKOKYAKUTELNOERRORKAISUU = new Item("dskokyakuseibi", "loginInfo", "dskokyakutelnoerrorkaisuu", null, ErrorMsgKbn.DD);

    static final Item DDID_LOGININFO_KAKUNINDSKOKTELNOERRKAISUU = new Item("dskokyakuseibi", "loginInfo", "kakunindskoktelnoerrkaisuu", null, ErrorMsgKbn.DD);

    static final Item DDID_DSMAILADDRESSINFO_DSMAILADDRESSRENBAN = new Item("dskokyakuseibi", "dsmailaddressInfo", "dsmailaddressrenban", null, ErrorMsgKbn.DISP);

    static final Item DDID_DSMAILADDRESSINFO_DSMAILADDRESS = new Item("dskokyakuseibi", "dsmailaddressInfo", "dsmailaddress", null, ErrorMsgKbn.DISP);

    static final Item DDID_DSMAILADDRESSINFO_INPUTDSMAILADDRESS = new Item("dskokyakuseibi", "dsmailaddressInfo", "inputdsmailaddress", null, ErrorMsgKbn.DD);

    static final Item DDID_DSMAILADDRESSINFO_KAKUNINDSMAILADDRESS = new Item("dskokyakuseibi", "dsmailaddressInfo", "kakunindsmailaddress", null, ErrorMsgKbn.DD);

    static final Item DDID_DSMAILADDRESSINFO_DSMAILSOUSINJYOUTAIKBN = new Item("dskokyakuseibi", "dsmailaddressInfo", "dsmailsousinjyoutaikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_DSMAILADDRESSINFO_INPUTDSMAILSOUSINJTKBN = new Item("dskokyakuseibi", "dsmailaddressInfo", "inputdsmailsousinjtkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSMAILADDRESSINFO_KAKUNINDSMAILSOUSINJTKBN = new Item("dskokyakuseibi", "dsmailaddressInfo", "kakunindsmailsousinjtkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSMAILADDRESSINFO_DSMAILSOUSINTISRYKBN = new Item("dskokyakuseibi", "dsmailaddressInfo", "dsmailsousintisrykbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_DSMAILADDRESSINFO_INPUTDSMAILSOUSINTISRYKBN = new Item("dskokyakuseibi", "dsmailaddressInfo", "inputdsmailsousintisrykbn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_DSMAILADDRESSINFO_KAKUNINDSMAILSOUSINTISRYKBN = new Item("dskokyakuseibi", "dsmailaddressInfo", "kakunindsmailsousintisrykbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_DSMAILADDRESSINFO_DISPDSKOUSINYMDTIME = new Item("dskokyakuseibi", "dsmailaddressInfo", "dispdskousinymdtime", null, ErrorMsgKbn.DD);

    static final Item DDID_DSMAILADDRESSINFO_KAKUNINDSKOUSINYMDTIME = new Item("dskokyakuseibi", "dsmailaddressInfo", "kakunindskousinymdtime", null, ErrorMsgKbn.DD);

    static final Item DDID_MONTHJISEISAINFO_SEISAHUYOUHYJ = new Item("dskokyakuseibi", "monthjiseisaInfo", "seisahuyouhyj", null, ErrorMsgKbn.DD);

    static final Item DDID_MONTHJISEISAINFO_INPUTSEISAHUYOUHYJ = new Item("dskokyakuseibi", "monthjiseisaInfo", "inputseisahuyouhyj", null, ErrorMsgKbn.DD);

    static final Item DDID_MONTHJISEISAINFO_KAKUNINSEISAHUYOUHYJ = new Item("dskokyakuseibi", "monthjiseisaInfo", "kakuninseisahuyouhyj", null, ErrorMsgKbn.DD);

    static final Item DDID_LASTKOSINFO_LASTJYUUHENYMD = new Item("dskokyakuseibi", "lastkosInfo", "lastjyuuhenymd", null, ErrorMsgKbn.DD);

    static final Item DDID_LASTKOSINFO_LASTKYKMEIGHNKYMD = new Item("dskokyakuseibi", "lastkosInfo", "lastkykmeighnkymd", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKKYKINFO_SYONO = new Item("dskokyakuseibi", "dskokkykInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKKYKINFO_SYUSYOUHNNM = new Item("dskokyakuseibi", "dskokkykInfo", "syusyouhnnm", null, ErrorMsgKbn.DISP);

    static final Item DDID_DSKOKKYKINFO_DSKYKKANYUUYMD = new Item("dskokyakuseibi", "dskokkykInfo", "dskykkanyuuymd", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKKYKINFO_DSKYKHENKOUYMD = new Item("dskokyakuseibi", "dskokkykInfo", "dskykhenkouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKKYKINFO_DSKYKMUKOUHYJ = new Item("dskokyakuseibi", "dskokkykInfo", "dskykmukouhyj", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKKYKINFO_DSKYKMUKOUYMD = new Item("dskokyakuseibi", "dskokkykInfo", "dskykmukouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_KYKBTDISPSYONO = new Item("dskokyakuseibi", "kihonInfo", "kykbtdispsyono", null, ErrorMsgKbn.DISP);

    static final Item DDID_KIHONINFO_KYKBTDISPDSKOKNO = new Item("dskokyakuseibi", "kihonInfo", "kykbtdispdskokno", null, ErrorMsgKbn.DISP);

    static final Item DDID_KIHONINFO_KYKBTDISPSYOUHNNM = new Item("dskokyakuseibi", "kihonInfo", "kykbtdispsyouhnnm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KYKBTHOZENINFO_KYKBTDISPKYKNMKJ = new Item("dskokyakuseibi", "kykbtHozenInfo", "kykbtdispkyknmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_KYKBTHOZENINFO_KYKBTDISPKYKNMKN = new Item("dskokyakuseibi", "kykbtHozenInfo", "kykbtdispkyknmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KYKBTHOZENINFO_KYKBTDISPKYKSEIYMD = new Item("dskokyakuseibi", "kykbtHozenInfo", "kykbtdispkykseiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_TRHKSERVICETOUROKUJK_DSTRHKSERVICERIYOUJKKBN = new Item("dskokyakuseibi", "trhkServiceTourokuJk", "dstrhkserviceriyoujkkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TRHKSERVICETOUROKUJK_KAKUNINDSTRHKSERVICERYJKKBN = new Item("dskokyakuseibi", "trhkServiceTourokuJk", "kakunindstrhkserviceryjkkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TRHKSERVICETOUROKUJK_DSTRHKSERVICETEISIRIYUUKBN = new Item("dskokyakuseibi", "trhkServiceTourokuJk", "dstrhkserviceteisiriyuukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TRHKSERVICETOUROKUJK_INPUTDSTRHKSVCTISRYKBN = new Item("dskokyakuseibi", "trhkServiceTourokuJk", "inputdstrhksvctisrykbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TRHKSERVICETOUROKUJK_KAKUNINDSTRHKSVCTISRYKBN = new Item("dskokyakuseibi", "trhkServiceTourokuJk", "kakunindstrhksvctisrykbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TRHKSERVICETOUROKUJK_DSTRHKSERVICEKANYUKEIROKBN = new Item("dskokyakuseibi", "trhkServiceTourokuJk", "dstrhkservicekanyukeirokbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUTEITRHKKOUZAINFO_KZSYURUIKBN = new Item("dskokyakuseibi", "tokuteiTrhkKouzaInfo", "kzsyuruikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUTEITRHKKOUZAINFO_BANKCD = new Item("dskokyakuseibi", "tokuteiTrhkKouzaInfo", "bankcd", null, ErrorMsgKbn.DD);

    static final Item DDID_TOKUTEITRHKKOUZAINFO_BANKNMKJ = new Item("dskokyakuseibi", "tokuteiTrhkKouzaInfo", "banknmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_TOKUTEITRHKKOUZAINFO_SITENCD = new Item("dskokyakuseibi", "tokuteiTrhkKouzaInfo", "sitencd", null, ErrorMsgKbn.DD);

    static final Item DDID_TOKUTEITRHKKOUZAINFO_SITENNMKJ = new Item("dskokyakuseibi", "tokuteiTrhkKouzaInfo", "sitennmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_TOKUTEITRHKKOUZAINFO_YOKINKBN = new Item("dskokyakuseibi", "tokuteiTrhkKouzaInfo", "yokinkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_TOKUTEITRHKKOUZAINFO_KOUZANO = new Item("dskokyakuseibi", "tokuteiTrhkKouzaInfo", "kouzano", null, ErrorMsgKbn.DD);

    static final Item DDID_TOKUTEITRHKKOUZAINFO_KZDOUKBN = new Item("dskokyakuseibi", "tokuteiTrhkKouzaInfo", "kzdoukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUTEITRHKKOUZAINFO_KZMEIGINMKN = new Item("dskokyakuseibi", "tokuteiTrhkKouzaInfo", "kzmeiginmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_TOKUTEITRHKANSYONOINFO_DISPTOKUTEITRHKANSYONO = new Item("dskokyakuseibi", "tokuteiTrhkAnsyonoInfo", "disptokuteitrhkansyono", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUTEITRHKANSYONOINFO_TKTRHKANSYONOERRORKAISUU = new Item("dskokyakuseibi", "tokuteiTrhkAnsyonoInfo", "tktrhkansyonoerrorkaisuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUTEITRHKANSYONOINFO_TOKUTEITRHKANSYONOSETYMD = new Item("dskokyakuseibi", "tokuteiTrhkAnsyonoInfo", "tokuteitrhkansyonosetymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTN = new Item("dskokyakuseibi", "footerButtons2", "modorubtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYINPUTCONTENTS = new Item("dskokyakuseibi", "footerButtons3", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS5_MODORUBTNBYCONFIRM = new Item("dskokyakuseibi", "footerButtons5", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS7_MODORUBTNBYKYKBTIC = new Item("dskokyakuseibi", "footerButtons7", "modorubtnbykykbtic", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS9_MODORUBTNBYKYKCONFIRM = new Item("dskokyakuseibi", "footerButtons9", "modorubtnbykykconfirm", null, ErrorMsgKbn.DD);
}
