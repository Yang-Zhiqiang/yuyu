package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.db.id.PKWT_KouteiSummary;
import yuyu.def.db.meta.GenQWT_KouteiSummary;
import yuyu.def.db.meta.QWT_KouteiSummary;

/**
 * 工程サマリテーブル テーブルのマッピング情報クラスで、 {@link WT_KouteiSummary} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_KouteiSummary}</td><td colspan="3">工程サマリテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getGyoumuKey gyoumuKey}</td><td>業務キー</td><td align="center">{@link PKWT_KouteiSummary ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLastSyoriTime lastSyoriTime}</td><td>最終処理時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyokaiAccountId syokaiAccountId}</td><td>初回アカウントＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenkaiAccountId zenkaiAccountId}</td><td>前回アカウントＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenkaiNodeNm zenkaiNodeNm}</td><td>前回ノード名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenkaiTaskLocalNm zenkaiTaskLocalNm}</td><td>前回タスクローカル名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNodeNm nodeNm}</td><td>ノード名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGenzaiAccountId genzaiAccountId}</td><td>現在アカウントＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGenzaiTaskLocalNm genzaiTaskLocalNm}</td><td>現在タスクローカル名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIwfKouteiKaisiYmd iwfKouteiKaisiYmd}</td><td>IWF工程開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouteiKanryouYmd kouteiKanryouYmd}</td><td>工程完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriStatus syoriStatus}</td><td>処理状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam1 extParam1}</td><td>拡張パラメータ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam2 extParam2}</td><td>拡張パラメータ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam3 extParam3}</td><td>拡張パラメータ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam4 extParam4}</td><td>拡張パラメータ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam5 extParam5}</td><td>拡張パラメータ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam6 extParam6}</td><td>拡張パラメータ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam7 extParam7}</td><td>拡張パラメータ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam8 extParam8}</td><td>拡張パラメータ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam9 extParam9}</td><td>拡張パラメータ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam10 extParam10}</td><td>拡張パラメータ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam11 extParam11}</td><td>拡張パラメータ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam12 extParam12}</td><td>拡張パラメータ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam13 extParam13}</td><td>拡張パラメータ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam14 extParam14}</td><td>拡張パラメータ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam15 extParam15}</td><td>拡張パラメータ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam16 extParam16}</td><td>拡張パラメータ１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam17 extParam17}</td><td>拡張パラメータ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam18 extParam18}</td><td>拡張パラメータ１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam19 extParam19}</td><td>拡張パラメータ１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam20 extParam20}</td><td>拡張パラメータ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam21 extParam21}</td><td>拡張パラメータ２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam22 extParam22}</td><td>拡張パラメータ２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam23 extParam23}</td><td>拡張パラメータ２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam24 extParam24}</td><td>拡張パラメータ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam25 extParam25}</td><td>拡張パラメータ２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam26 extParam26}</td><td>拡張パラメータ２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam27 extParam27}</td><td>拡張パラメータ２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam28 extParam28}</td><td>拡張パラメータ２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam29 extParam29}</td><td>拡張パラメータ２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam30 extParam30}</td><td>拡張パラメータ３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_KouteiSummary
 * @see     PKWT_KouteiSummary
 * @see     QWT_KouteiSummary
 * @see     GenQWT_KouteiSummary
 */
@MappedSuperclass
@Table(name=GenWT_KouteiSummary.TABLE_NAME)
@IdClass(value=PKWT_KouteiSummary.class)
public abstract class GenWT_KouteiSummary extends AbstractExDBEntity<WT_KouteiSummary, PKWT_KouteiSummary> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_KouteiSummary";
    public static final String GYOUMUKEY                = "gyoumuKey";
    public static final String FLOWID                   = "flowId";
    public static final String LASTSYORITIME            = "lastSyoriTime";
    public static final String SYOKAIACCOUNTID          = "syokaiAccountId";
    public static final String ZENKAIACCOUNTID          = "zenkaiAccountId";
    public static final String ZENKAINODENM             = "zenkaiNodeNm";
    public static final String ZENKAITASKLOCALNM        = "zenkaiTaskLocalNm";
    public static final String NODENM                   = "nodeNm";
    public static final String GENZAIACCOUNTID          = "genzaiAccountId";
    public static final String GENZAITASKLOCALNM        = "genzaiTaskLocalNm";
    public static final String IWFKOUTEIKAISIYMD        = "iwfKouteiKaisiYmd";
    public static final String KOUTEIKANRYOUYMD         = "kouteiKanryouYmd";
    public static final String SYORISTATUS              = "syoriStatus";
    public static final String EXTPARAM1                = "extParam1";
    public static final String EXTPARAM2                = "extParam2";
    public static final String EXTPARAM3                = "extParam3";
    public static final String EXTPARAM4                = "extParam4";
    public static final String EXTPARAM5                = "extParam5";
    public static final String EXTPARAM6                = "extParam6";
    public static final String EXTPARAM7                = "extParam7";
    public static final String EXTPARAM8                = "extParam8";
    public static final String EXTPARAM9                = "extParam9";
    public static final String EXTPARAM10               = "extParam10";
    public static final String EXTPARAM11               = "extParam11";
    public static final String EXTPARAM12               = "extParam12";
    public static final String EXTPARAM13               = "extParam13";
    public static final String EXTPARAM14               = "extParam14";
    public static final String EXTPARAM15               = "extParam15";
    public static final String EXTPARAM16               = "extParam16";
    public static final String EXTPARAM17               = "extParam17";
    public static final String EXTPARAM18               = "extParam18";
    public static final String EXTPARAM19               = "extParam19";
    public static final String EXTPARAM20               = "extParam20";
    public static final String EXTPARAM21               = "extParam21";
    public static final String EXTPARAM22               = "extParam22";
    public static final String EXTPARAM23               = "extParam23";
    public static final String EXTPARAM24               = "extParam24";
    public static final String EXTPARAM25               = "extParam25";
    public static final String EXTPARAM26               = "extParam26";
    public static final String EXTPARAM27               = "extParam27";
    public static final String EXTPARAM28               = "extParam28";
    public static final String EXTPARAM29               = "extParam29";
    public static final String EXTPARAM30               = "extParam30";

    private final PKWT_KouteiSummary primaryKey;

    public GenWT_KouteiSummary() {
        primaryKey = new PKWT_KouteiSummary();
    }

    public GenWT_KouteiSummary(String pGyoumuKey) {
        primaryKey = new PKWT_KouteiSummary(pGyoumuKey);
    }

    @Transient
    @Override
    public PKWT_KouteiSummary getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_KouteiSummary> getMetaClass() {
        return QWT_KouteiSummary.class;
    }

    @Id
    @Column(name=GenWT_KouteiSummary.GYOUMUKEY)
    public String getGyoumuKey() {
        return getPrimaryKey().getGyoumuKey();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setGyoumuKey(String pGyoumuKey) {
        getPrimaryKey().setGyoumuKey(pGyoumuKey);
    }

    private String flowId;

    @Column(name=GenWT_KouteiSummary.FLOWID)
    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String pFlowId) {
        flowId = pFlowId;
    }

    private String lastSyoriTime;

    @Column(name=GenWT_KouteiSummary.LASTSYORITIME)
    public String getLastSyoriTime() {
        return lastSyoriTime;
    }

    public void setLastSyoriTime(String pLastSyoriTime) {
        lastSyoriTime = pLastSyoriTime;
    }

    private String syokaiAccountId;

    @Column(name=GenWT_KouteiSummary.SYOKAIACCOUNTID)
    public String getSyokaiAccountId() {
        return syokaiAccountId;
    }

    public void setSyokaiAccountId(String pSyokaiAccountId) {
        syokaiAccountId = pSyokaiAccountId;
    }

    private String zenkaiAccountId;

    @Column(name=GenWT_KouteiSummary.ZENKAIACCOUNTID)
    public String getZenkaiAccountId() {
        return zenkaiAccountId;
    }

    public void setZenkaiAccountId(String pZenkaiAccountId) {
        zenkaiAccountId = pZenkaiAccountId;
    }

    private String zenkaiNodeNm;

    @Column(name=GenWT_KouteiSummary.ZENKAINODENM)
    public String getZenkaiNodeNm() {
        return zenkaiNodeNm;
    }

    public void setZenkaiNodeNm(String pZenkaiNodeNm) {
        zenkaiNodeNm = pZenkaiNodeNm;
    }

    private String zenkaiTaskLocalNm;

    @Column(name=GenWT_KouteiSummary.ZENKAITASKLOCALNM)
    public String getZenkaiTaskLocalNm() {
        return zenkaiTaskLocalNm;
    }

    public void setZenkaiTaskLocalNm(String pZenkaiTaskLocalNm) {
        zenkaiTaskLocalNm = pZenkaiTaskLocalNm;
    }

    private String nodeNm;

    @Column(name=GenWT_KouteiSummary.NODENM)
    public String getNodeNm() {
        return nodeNm;
    }

    public void setNodeNm(String pNodeNm) {
        nodeNm = pNodeNm;
    }

    private String genzaiAccountId;

    @Column(name=GenWT_KouteiSummary.GENZAIACCOUNTID)
    public String getGenzaiAccountId() {
        return genzaiAccountId;
    }

    public void setGenzaiAccountId(String pGenzaiAccountId) {
        genzaiAccountId = pGenzaiAccountId;
    }

    private String genzaiTaskLocalNm;

    @Column(name=GenWT_KouteiSummary.GENZAITASKLOCALNM)
    public String getGenzaiTaskLocalNm() {
        return genzaiTaskLocalNm;
    }

    public void setGenzaiTaskLocalNm(String pGenzaiTaskLocalNm) {
        genzaiTaskLocalNm = pGenzaiTaskLocalNm;
    }

    private String iwfKouteiKaisiYmd;

    @Column(name=GenWT_KouteiSummary.IWFKOUTEIKAISIYMD)
    public String getIwfKouteiKaisiYmd() {
        return iwfKouteiKaisiYmd;
    }

    public void setIwfKouteiKaisiYmd(String pIwfKouteiKaisiYmd) {
        iwfKouteiKaisiYmd = pIwfKouteiKaisiYmd;
    }

    private String kouteiKanryouYmd;

    @Column(name=GenWT_KouteiSummary.KOUTEIKANRYOUYMD)
    public String getKouteiKanryouYmd() {
        return kouteiKanryouYmd;
    }

    public void setKouteiKanryouYmd(String pKouteiKanryouYmd) {
        kouteiKanryouYmd = pKouteiKanryouYmd;
    }

    private String syoriStatus;

    @Column(name=GenWT_KouteiSummary.SYORISTATUS)
    public String getSyoriStatus() {
        return syoriStatus;
    }

    public void setSyoriStatus(String pSyoriStatus) {
        syoriStatus = pSyoriStatus;
    }

    private String extParam1;

    @Column(name=GenWT_KouteiSummary.EXTPARAM1)
    public String getExtParam1() {
        return extParam1;
    }

    public void setExtParam1(String pExtParam1) {
        extParam1 = pExtParam1;
    }

    private String extParam2;

    @Column(name=GenWT_KouteiSummary.EXTPARAM2)
    public String getExtParam2() {
        return extParam2;
    }

    public void setExtParam2(String pExtParam2) {
        extParam2 = pExtParam2;
    }

    private String extParam3;

    @Column(name=GenWT_KouteiSummary.EXTPARAM3)
    public String getExtParam3() {
        return extParam3;
    }

    public void setExtParam3(String pExtParam3) {
        extParam3 = pExtParam3;
    }

    private String extParam4;

    @Column(name=GenWT_KouteiSummary.EXTPARAM4)
    public String getExtParam4() {
        return extParam4;
    }

    public void setExtParam4(String pExtParam4) {
        extParam4 = pExtParam4;
    }

    private String extParam5;

    @Column(name=GenWT_KouteiSummary.EXTPARAM5)
    public String getExtParam5() {
        return extParam5;
    }

    public void setExtParam5(String pExtParam5) {
        extParam5 = pExtParam5;
    }

    private String extParam6;

    @Column(name=GenWT_KouteiSummary.EXTPARAM6)
    public String getExtParam6() {
        return extParam6;
    }

    public void setExtParam6(String pExtParam6) {
        extParam6 = pExtParam6;
    }

    private String extParam7;

    @Column(name=GenWT_KouteiSummary.EXTPARAM7)
    public String getExtParam7() {
        return extParam7;
    }

    public void setExtParam7(String pExtParam7) {
        extParam7 = pExtParam7;
    }

    private String extParam8;

    @Column(name=GenWT_KouteiSummary.EXTPARAM8)
    public String getExtParam8() {
        return extParam8;
    }

    public void setExtParam8(String pExtParam8) {
        extParam8 = pExtParam8;
    }

    private String extParam9;

    @Column(name=GenWT_KouteiSummary.EXTPARAM9)
    public String getExtParam9() {
        return extParam9;
    }

    public void setExtParam9(String pExtParam9) {
        extParam9 = pExtParam9;
    }

    private String extParam10;

    @Column(name=GenWT_KouteiSummary.EXTPARAM10)
    public String getExtParam10() {
        return extParam10;
    }

    public void setExtParam10(String pExtParam10) {
        extParam10 = pExtParam10;
    }

    private String extParam11;

    @Column(name=GenWT_KouteiSummary.EXTPARAM11)
    public String getExtParam11() {
        return extParam11;
    }

    public void setExtParam11(String pExtParam11) {
        extParam11 = pExtParam11;
    }

    private String extParam12;

    @Column(name=GenWT_KouteiSummary.EXTPARAM12)
    public String getExtParam12() {
        return extParam12;
    }

    public void setExtParam12(String pExtParam12) {
        extParam12 = pExtParam12;
    }

    private String extParam13;

    @Column(name=GenWT_KouteiSummary.EXTPARAM13)
    public String getExtParam13() {
        return extParam13;
    }

    public void setExtParam13(String pExtParam13) {
        extParam13 = pExtParam13;
    }

    private String extParam14;

    @Column(name=GenWT_KouteiSummary.EXTPARAM14)
    public String getExtParam14() {
        return extParam14;
    }

    public void setExtParam14(String pExtParam14) {
        extParam14 = pExtParam14;
    }

    private String extParam15;

    @Column(name=GenWT_KouteiSummary.EXTPARAM15)
    public String getExtParam15() {
        return extParam15;
    }

    public void setExtParam15(String pExtParam15) {
        extParam15 = pExtParam15;
    }

    private String extParam16;

    @Column(name=GenWT_KouteiSummary.EXTPARAM16)
    public String getExtParam16() {
        return extParam16;
    }

    public void setExtParam16(String pExtParam16) {
        extParam16 = pExtParam16;
    }

    private String extParam17;

    @Column(name=GenWT_KouteiSummary.EXTPARAM17)
    public String getExtParam17() {
        return extParam17;
    }

    public void setExtParam17(String pExtParam17) {
        extParam17 = pExtParam17;
    }

    private String extParam18;

    @Column(name=GenWT_KouteiSummary.EXTPARAM18)
    public String getExtParam18() {
        return extParam18;
    }

    public void setExtParam18(String pExtParam18) {
        extParam18 = pExtParam18;
    }

    private String extParam19;

    @Column(name=GenWT_KouteiSummary.EXTPARAM19)
    public String getExtParam19() {
        return extParam19;
    }

    public void setExtParam19(String pExtParam19) {
        extParam19 = pExtParam19;
    }

    private String extParam20;

    @Column(name=GenWT_KouteiSummary.EXTPARAM20)
    public String getExtParam20() {
        return extParam20;
    }

    public void setExtParam20(String pExtParam20) {
        extParam20 = pExtParam20;
    }

    private String extParam21;

    @Column(name=GenWT_KouteiSummary.EXTPARAM21)
    public String getExtParam21() {
        return extParam21;
    }

    public void setExtParam21(String pExtParam21) {
        extParam21 = pExtParam21;
    }

    private String extParam22;

    @Column(name=GenWT_KouteiSummary.EXTPARAM22)
    public String getExtParam22() {
        return extParam22;
    }

    public void setExtParam22(String pExtParam22) {
        extParam22 = pExtParam22;
    }

    private String extParam23;

    @Column(name=GenWT_KouteiSummary.EXTPARAM23)
    public String getExtParam23() {
        return extParam23;
    }

    public void setExtParam23(String pExtParam23) {
        extParam23 = pExtParam23;
    }

    private String extParam24;

    @Column(name=GenWT_KouteiSummary.EXTPARAM24)
    public String getExtParam24() {
        return extParam24;
    }

    public void setExtParam24(String pExtParam24) {
        extParam24 = pExtParam24;
    }

    private String extParam25;

    @Column(name=GenWT_KouteiSummary.EXTPARAM25)
    public String getExtParam25() {
        return extParam25;
    }

    public void setExtParam25(String pExtParam25) {
        extParam25 = pExtParam25;
    }

    private String extParam26;

    @Column(name=GenWT_KouteiSummary.EXTPARAM26)
    public String getExtParam26() {
        return extParam26;
    }

    public void setExtParam26(String pExtParam26) {
        extParam26 = pExtParam26;
    }

    private String extParam27;

    @Column(name=GenWT_KouteiSummary.EXTPARAM27)
    public String getExtParam27() {
        return extParam27;
    }

    public void setExtParam27(String pExtParam27) {
        extParam27 = pExtParam27;
    }

    private String extParam28;

    @Column(name=GenWT_KouteiSummary.EXTPARAM28)
    public String getExtParam28() {
        return extParam28;
    }

    public void setExtParam28(String pExtParam28) {
        extParam28 = pExtParam28;
    }

    private String extParam29;

    @Column(name=GenWT_KouteiSummary.EXTPARAM29)
    public String getExtParam29() {
        return extParam29;
    }

    public void setExtParam29(String pExtParam29) {
        extParam29 = pExtParam29;
    }

    private String extParam30;

    @Column(name=GenWT_KouteiSummary.EXTPARAM30)
    public String getExtParam30() {
        return extParam30;
    }

    public void setExtParam30(String pExtParam30) {
        extParam30 = pExtParam30;
    }
}