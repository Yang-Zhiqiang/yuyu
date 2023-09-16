package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.id.PKZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.meta.GenQZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.meta.QZT_SyuHukugouSikkanDataRn;

/**
 * 普保Ⅱ主契約複合疾患データテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SyuHukugouSikkanDataRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyuHukugouSikkanDataRn}</td><td colspan="3">普保Ⅱ主契約複合疾患データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnijitoukeidaihyousyurui zrnijitoukeidaihyousyurui}</td><td>（連携用）医事統計用代表種類</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakunendo zrnkeiyakunendo}</td><td>（連携用）契約年度</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknnendo zrnhknnendo}</td><td>（連携用）保険年度</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykage zrnkykage}</td><td>（連携用）加入年齢</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoutatunenrei zrntoutatunenrei}</td><td>（連携用）到達年齢</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatukaibetu zrnatukaibetu}</td><td>（連携用）扱別</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsahouhou zrnsinsahouhou}</td><td>（連携用）診査方法</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketteikekkakbn zrnketteikekkakbn}</td><td>（連携用）決定結果区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibousrank zrnsibousrank}</td><td>（連携用）死亡Ｓランク</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjissituhosyousrank zrnjissituhosyousrank}</td><td>（連携用）実質保障Ｓランク</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsirajikykkbn zrnsirajikykkbn}</td><td>（連携用）白地契約区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkhuhukbn zrnhrkhuhukbn}</td><td>（連携用）払込方法区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyurui2keta zrnhknsyurui2keta}</td><td>（連携用）保険種類（２桁）</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaisiincd zrndaisiincd}</td><td>（連携用）大死因コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuusiincd zrntyuusiincd}</td><td>（連携用）中死因コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyousiincd zrnsyousiincd}</td><td>（連携用）小死因コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenreihousikikbn zrnnenreihousikikbn}</td><td>（連携用）年令方式区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntodouhukencd zrntodouhukencd}</td><td>（連携用）都道府県コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbotaisisyaeigyouhonbu zrnbotaisisyaeigyouhonbu}</td><td>（連携用）母体支社営業本部</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisyaeigyoubu zrnsisyaeigyoubu}</td><td>（連携用）支社営業部</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisosikicd zrnaatukaisosikicd}</td><td>（連携用）Ａ扱者組織コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnensyuukbn zrnnensyuukbn}</td><td>（連携用）年収区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhanbaikeirokbn zrnhanbaikeirokbn}</td><td>（連携用）販売経路区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnoyadairitencd zrnoyadairitencd}</td><td>（連携用）親代理店コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntratkidrtencd zrntratkidrtencd}</td><td>（連携用）取扱代理店コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktuuka zrnkyktuuka}</td><td>（連携用）契約通貨</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrktuuka zrnhrktuuka}</td><td>（連携用）払込通貨</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyksbyensitihsyutyhkumu zrnsyksbyensitihsyutyhkumu}</td><td>（連携用）初期死亡時円換算最低保証特約付加有無</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyudkaigomehrtkhkumu zrnjyudkaigomehrtkhkumu}</td><td>（連携用）重度介護前払特約付加有無</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnijitoukeizennoukbn zrnijitoukeizennoukbn}</td><td>（連携用）医事統計用前納区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnijitoukeitikshrtkykkbn zrnijitoukeitikshrtkykkbn}</td><td>（連携用）医事統計用定期支払特約区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv31 zrnyobiv31}</td><td>（連携用）予備項目Ｖ３１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnijitoukeikeikan zrnijitoukeikeikan}</td><td>（連携用）医事統計用経過Ｎ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnijitoukeisiboun zrnijitoukeisiboun}</td><td>（連携用）医事統計用死亡Ｎ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnijitoukeikeikas zrnijitoukeikeikas}</td><td>（連携用）医事統計用経過Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnijitoukeisibous zrnijitoukeisibous}</td><td>（連携用）医事統計用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv20 zrnyobiv20}</td><td>（連携用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyuHukugouSikkanDataRn
 * @see     PKZT_SyuHukugouSikkanDataRn
 * @see     QZT_SyuHukugouSikkanDataRn
 * @see     GenQZT_SyuHukugouSikkanDataRn
 */
@MappedSuperclass
@Table(name=GenZT_SyuHukugouSikkanDataRn.TABLE_NAME)
@IdClass(value=PKZT_SyuHukugouSikkanDataRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SyuHukugouSikkanDataRn extends AbstractExDBEntityForZDB<ZT_SyuHukugouSikkanDataRn, PKZT_SyuHukugouSikkanDataRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyuHukugouSikkanDataRn";
    public static final String ZRNIJITOUKEIDAIHYOUSYURUI = "zrnijitoukeidaihyousyurui";
    public static final String ZRNKEIYAKUNENDO          = "zrnkeiyakunendo";
    public static final String ZRNHKNNENDO              = "zrnhknnendo";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNKYKAGE                = "zrnkykage";
    public static final String ZRNTOUTATUNENREI         = "zrntoutatunenrei";
    public static final String ZRNATUKAIBETU            = "zrnatukaibetu";
    public static final String ZRNSINSAHOUHOU           = "zrnsinsahouhou";
    public static final String ZRNKETTEIKEKKAKBN        = "zrnketteikekkakbn";
    public static final String ZRNSIBOUSRANK            = "zrnsibousrank";
    public static final String ZRNJISSITUHOSYOUSRANK    = "zrnjissituhosyousrank";
    public static final String ZRNSIRAJIKYKKBN          = "zrnsirajikykkbn";
    public static final String ZRNHRKHUHUKBN            = "zrnhrkhuhukbn";
    public static final String ZRNHKNSYURUI2KETA        = "zrnhknsyurui2keta";
    public static final String ZRNDAISIINCD             = "zrndaisiincd";
    public static final String ZRNTYUUSIINCD            = "zrntyuusiincd";
    public static final String ZRNSYOUSIINCD            = "zrnsyousiincd";
    public static final String ZRNNENREIHOUSIKIKBN      = "zrnnenreihousikikbn";
    public static final String ZRNSYKGYCD               = "zrnsykgycd";
    public static final String ZRNTODOUHUKENCD          = "zrntodouhukencd";
    public static final String ZRNBOTAISISYAEIGYOUHONBU = "zrnbotaisisyaeigyouhonbu";
    public static final String ZRNSISYAEIGYOUBU         = "zrnsisyaeigyoubu";
    public static final String ZRNAATUKAISOSIKICD       = "zrnaatukaisosikicd";
    public static final String ZRNNENSYUUKBN            = "zrnnensyuukbn";
    public static final String ZRNHANBAIKEIROKBN        = "zrnhanbaikeirokbn";
    public static final String ZRNOYADAIRITENCD         = "zrnoyadairitencd";
    public static final String ZRNTRATKIDRTENCD         = "zrntratkidrtencd";
    public static final String ZRNBSUDIRTNATKIKEITAIKBN = "zrnbsudirtnatkikeitaikbn";
    public static final String ZRNKYKTUUKA              = "zrnkyktuuka";
    public static final String ZRNHRKTUUKA              = "zrnhrktuuka";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNSYKSBYENSITIHSYUTYHKUMU = "zrnsyksbyensitihsyutyhkumu";
    public static final String ZRNJYUDKAIGOMEHRTKHKUMU  = "zrnjyudkaigomehrtkhkumu";
    public static final String ZRNIJITOUKEIZENNOUKBN    = "zrnijitoukeizennoukbn";
    public static final String ZRNDAI1HKNKKN            = "zrndai1hknkkn";
    public static final String ZRNIJITOUKEITIKSHRTKYKKBN = "zrnijitoukeitikshrtkykkbn";
    public static final String ZRNYOBIV31               = "zrnyobiv31";
    public static final String ZRNIJITOUKEIKEIKAN       = "zrnijitoukeikeikan";
    public static final String ZRNIJITOUKEISIBOUN       = "zrnijitoukeisiboun";
    public static final String ZRNIJITOUKEIKEIKAS       = "zrnijitoukeikeikas";
    public static final String ZRNIJITOUKEISIBOUS       = "zrnijitoukeisibous";
    public static final String ZRNYOBIV20               = "zrnyobiv20";

    private final PKZT_SyuHukugouSikkanDataRn primaryKey;

    public GenZT_SyuHukugouSikkanDataRn() {
        primaryKey = new PKZT_SyuHukugouSikkanDataRn();
    }

    public GenZT_SyuHukugouSikkanDataRn(
        String pZrnijitoukeidaihyousyurui,
        String pZrnkeiyakunendo,
        String pZrnhknnendo,
        String pZrnhhknseikbn,
        String pZrnkykage,
        String pZrntoutatunenrei,
        String pZrnatukaibetu,
        String pZrnsinsahouhou,
        String pZrnketteikekkakbn,
        String pZrnsibousrank,
        String pZrnjissituhosyousrank,
        String pZrnsirajikykkbn,
        String pZrnhrkhuhukbn,
        String pZrnhknsyurui2keta,
        String pZrndaisiincd,
        String pZrntyuusiincd,
        String pZrnsyousiincd,
        String pZrnnenreihousikikbn,
        String pZrnsykgycd,
        String pZrntodouhukencd,
        String pZrnbotaisisyaeigyouhonbu,
        String pZrnsisyaeigyoubu,
        String pZrnaatukaisosikicd,
        String pZrnnensyuukbn,
        String pZrnhanbaikeirokbn,
        String pZrnoyadairitencd,
        String pZrntratkidrtencd,
        String pZrnbsudirtnatkikeitaikbn,
        String pZrnkyktuuka,
        String pZrnhrktuuka,
        String pZrnhknsyukigou,
        String pZrnsyksbyensitihsyutyhkumu,
        String pZrnjyudkaigomehrtkhkumu,
        String pZrnijitoukeizennoukbn,
        String pZrndai1hknkkn,
        String pZrnijitoukeitikshrtkykkbn
    ) {
        primaryKey = new PKZT_SyuHukugouSikkanDataRn(
            pZrnijitoukeidaihyousyurui,
            pZrnkeiyakunendo,
            pZrnhknnendo,
            pZrnhhknseikbn,
            pZrnkykage,
            pZrntoutatunenrei,
            pZrnatukaibetu,
            pZrnsinsahouhou,
            pZrnketteikekkakbn,
            pZrnsibousrank,
            pZrnjissituhosyousrank,
            pZrnsirajikykkbn,
            pZrnhrkhuhukbn,
            pZrnhknsyurui2keta,
            pZrndaisiincd,
            pZrntyuusiincd,
            pZrnsyousiincd,
            pZrnnenreihousikikbn,
            pZrnsykgycd,
            pZrntodouhukencd,
            pZrnbotaisisyaeigyouhonbu,
            pZrnsisyaeigyoubu,
            pZrnaatukaisosikicd,
            pZrnnensyuukbn,
            pZrnhanbaikeirokbn,
            pZrnoyadairitencd,
            pZrntratkidrtencd,
            pZrnbsudirtnatkikeitaikbn,
            pZrnkyktuuka,
            pZrnhrktuuka,
            pZrnhknsyukigou,
            pZrnsyksbyensitihsyutyhkumu,
            pZrnjyudkaigomehrtkhkumu,
            pZrnijitoukeizennoukbn,
            pZrndai1hknkkn,
            pZrnijitoukeitikshrtkykkbn
        );
    }

    @Transient
    @Override
    public PKZT_SyuHukugouSikkanDataRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyuHukugouSikkanDataRn> getMetaClass() {
        return QZT_SyuHukugouSikkanDataRn.class;
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNIJITOUKEIDAIHYOUSYURUI)
    public String getZrnijitoukeidaihyousyurui() {
        return getPrimaryKey().getZrnijitoukeidaihyousyurui();
    }

    public void setZrnijitoukeidaihyousyurui(String pZrnijitoukeidaihyousyurui) {
        getPrimaryKey().setZrnijitoukeidaihyousyurui(pZrnijitoukeidaihyousyurui);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNKEIYAKUNENDO)
    public String getZrnkeiyakunendo() {
        return getPrimaryKey().getZrnkeiyakunendo();
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkeiyakunendo(String pZrnkeiyakunendo) {
        getPrimaryKey().setZrnkeiyakunendo(pZrnkeiyakunendo);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNHKNNENDO)
    public String getZrnhknnendo() {
        return getPrimaryKey().getZrnhknnendo();
    }

    public void setZrnhknnendo(String pZrnhknnendo) {
        getPrimaryKey().setZrnhknnendo(pZrnhknnendo);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return getPrimaryKey().getZrnhhknseikbn();
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        getPrimaryKey().setZrnhhknseikbn(pZrnhhknseikbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNKYKAGE)
    public String getZrnkykage() {
        return getPrimaryKey().getZrnkykage();
    }

    public void setZrnkykage(String pZrnkykage) {
        getPrimaryKey().setZrnkykage(pZrnkykage);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNTOUTATUNENREI)
    public String getZrntoutatunenrei() {
        return getPrimaryKey().getZrntoutatunenrei();
    }

    public void setZrntoutatunenrei(String pZrntoutatunenrei) {
        getPrimaryKey().setZrntoutatunenrei(pZrntoutatunenrei);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNATUKAIBETU)
    public String getZrnatukaibetu() {
        return getPrimaryKey().getZrnatukaibetu();
    }

    public void setZrnatukaibetu(String pZrnatukaibetu) {
        getPrimaryKey().setZrnatukaibetu(pZrnatukaibetu);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNSINSAHOUHOU)
    public String getZrnsinsahouhou() {
        return getPrimaryKey().getZrnsinsahouhou();
    }

    public void setZrnsinsahouhou(String pZrnsinsahouhou) {
        getPrimaryKey().setZrnsinsahouhou(pZrnsinsahouhou);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNKETTEIKEKKAKBN)
    public String getZrnketteikekkakbn() {
        return getPrimaryKey().getZrnketteikekkakbn();
    }

    public void setZrnketteikekkakbn(String pZrnketteikekkakbn) {
        getPrimaryKey().setZrnketteikekkakbn(pZrnketteikekkakbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNSIBOUSRANK)
    public String getZrnsibousrank() {
        return getPrimaryKey().getZrnsibousrank();
    }

    public void setZrnsibousrank(String pZrnsibousrank) {
        getPrimaryKey().setZrnsibousrank(pZrnsibousrank);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNJISSITUHOSYOUSRANK)
    public String getZrnjissituhosyousrank() {
        return getPrimaryKey().getZrnjissituhosyousrank();
    }

    public void setZrnjissituhosyousrank(String pZrnjissituhosyousrank) {
        getPrimaryKey().setZrnjissituhosyousrank(pZrnjissituhosyousrank);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNSIRAJIKYKKBN)
    public String getZrnsirajikykkbn() {
        return getPrimaryKey().getZrnsirajikykkbn();
    }

    public void setZrnsirajikykkbn(String pZrnsirajikykkbn) {
        getPrimaryKey().setZrnsirajikykkbn(pZrnsirajikykkbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNHRKHUHUKBN)
    public String getZrnhrkhuhukbn() {
        return getPrimaryKey().getZrnhrkhuhukbn();
    }

    public void setZrnhrkhuhukbn(String pZrnhrkhuhukbn) {
        getPrimaryKey().setZrnhrkhuhukbn(pZrnhrkhuhukbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNHKNSYURUI2KETA)
    public String getZrnhknsyurui2keta() {
        return getPrimaryKey().getZrnhknsyurui2keta();
    }

    public void setZrnhknsyurui2keta(String pZrnhknsyurui2keta) {
        getPrimaryKey().setZrnhknsyurui2keta(pZrnhknsyurui2keta);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNDAISIINCD)
    public String getZrndaisiincd() {
        return getPrimaryKey().getZrndaisiincd();
    }

    public void setZrndaisiincd(String pZrndaisiincd) {
        getPrimaryKey().setZrndaisiincd(pZrndaisiincd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNTYUUSIINCD)
    public String getZrntyuusiincd() {
        return getPrimaryKey().getZrntyuusiincd();
    }

    public void setZrntyuusiincd(String pZrntyuusiincd) {
        getPrimaryKey().setZrntyuusiincd(pZrntyuusiincd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNSYOUSIINCD)
    public String getZrnsyousiincd() {
        return getPrimaryKey().getZrnsyousiincd();
    }

    public void setZrnsyousiincd(String pZrnsyousiincd) {
        getPrimaryKey().setZrnsyousiincd(pZrnsyousiincd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNNENREIHOUSIKIKBN)
    public String getZrnnenreihousikikbn() {
        return getPrimaryKey().getZrnnenreihousikikbn();
    }

    public void setZrnnenreihousikikbn(String pZrnnenreihousikikbn) {
        getPrimaryKey().setZrnnenreihousikikbn(pZrnnenreihousikikbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNSYKGYCD)
    public String getZrnsykgycd() {
        return getPrimaryKey().getZrnsykgycd();
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        getPrimaryKey().setZrnsykgycd(pZrnsykgycd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNTODOUHUKENCD)
    public String getZrntodouhukencd() {
        return getPrimaryKey().getZrntodouhukencd();
    }

    public void setZrntodouhukencd(String pZrntodouhukencd) {
        getPrimaryKey().setZrntodouhukencd(pZrntodouhukencd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNBOTAISISYAEIGYOUHONBU)
    public String getZrnbotaisisyaeigyouhonbu() {
        return getPrimaryKey().getZrnbotaisisyaeigyouhonbu();
    }

    public void setZrnbotaisisyaeigyouhonbu(String pZrnbotaisisyaeigyouhonbu) {
        getPrimaryKey().setZrnbotaisisyaeigyouhonbu(pZrnbotaisisyaeigyouhonbu);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNSISYAEIGYOUBU)
    public String getZrnsisyaeigyoubu() {
        return getPrimaryKey().getZrnsisyaeigyoubu();
    }

    public void setZrnsisyaeigyoubu(String pZrnsisyaeigyoubu) {
        getPrimaryKey().setZrnsisyaeigyoubu(pZrnsisyaeigyoubu);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNAATUKAISOSIKICD)
    public String getZrnaatukaisosikicd() {
        return getPrimaryKey().getZrnaatukaisosikicd();
    }

    public void setZrnaatukaisosikicd(String pZrnaatukaisosikicd) {
        getPrimaryKey().setZrnaatukaisosikicd(pZrnaatukaisosikicd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNNENSYUUKBN)
    public String getZrnnensyuukbn() {
        return getPrimaryKey().getZrnnensyuukbn();
    }

    public void setZrnnensyuukbn(String pZrnnensyuukbn) {
        getPrimaryKey().setZrnnensyuukbn(pZrnnensyuukbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNHANBAIKEIROKBN)
    public String getZrnhanbaikeirokbn() {
        return getPrimaryKey().getZrnhanbaikeirokbn();
    }

    public void setZrnhanbaikeirokbn(String pZrnhanbaikeirokbn) {
        getPrimaryKey().setZrnhanbaikeirokbn(pZrnhanbaikeirokbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNOYADAIRITENCD)
    public String getZrnoyadairitencd() {
        return getPrimaryKey().getZrnoyadairitencd();
    }

    public void setZrnoyadairitencd(String pZrnoyadairitencd) {
        getPrimaryKey().setZrnoyadairitencd(pZrnoyadairitencd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNTRATKIDRTENCD)
    public String getZrntratkidrtencd() {
        return getPrimaryKey().getZrntratkidrtencd();
    }

    public void setZrntratkidrtencd(String pZrntratkidrtencd) {
        getPrimaryKey().setZrntratkidrtencd(pZrntratkidrtencd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNBSUDIRTNATKIKEITAIKBN)
    public String getZrnbsudirtnatkikeitaikbn() {
        return getPrimaryKey().getZrnbsudirtnatkikeitaikbn();
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        getPrimaryKey().setZrnbsudirtnatkikeitaikbn(pZrnbsudirtnatkikeitaikbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNKYKTUUKA)
    public String getZrnkyktuuka() {
        return getPrimaryKey().getZrnkyktuuka();
    }

    public void setZrnkyktuuka(String pZrnkyktuuka) {
        getPrimaryKey().setZrnkyktuuka(pZrnkyktuuka);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNHRKTUUKA)
    public String getZrnhrktuuka() {
        return getPrimaryKey().getZrnhrktuuka();
    }

    public void setZrnhrktuuka(String pZrnhrktuuka) {
        getPrimaryKey().setZrnhrktuuka(pZrnhrktuuka);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return getPrimaryKey().getZrnhknsyukigou();
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        getPrimaryKey().setZrnhknsyukigou(pZrnhknsyukigou);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNSYKSBYENSITIHSYUTYHKUMU)
    public String getZrnsyksbyensitihsyutyhkumu() {
        return getPrimaryKey().getZrnsyksbyensitihsyutyhkumu();
    }

    public void setZrnsyksbyensitihsyutyhkumu(String pZrnsyksbyensitihsyutyhkumu) {
        getPrimaryKey().setZrnsyksbyensitihsyutyhkumu(pZrnsyksbyensitihsyutyhkumu);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNJYUDKAIGOMEHRTKHKUMU)
    public String getZrnjyudkaigomehrtkhkumu() {
        return getPrimaryKey().getZrnjyudkaigomehrtkhkumu();
    }

    public void setZrnjyudkaigomehrtkhkumu(String pZrnjyudkaigomehrtkhkumu) {
        getPrimaryKey().setZrnjyudkaigomehrtkhkumu(pZrnjyudkaigomehrtkhkumu);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNIJITOUKEIZENNOUKBN)
    public String getZrnijitoukeizennoukbn() {
        return getPrimaryKey().getZrnijitoukeizennoukbn();
    }

    public void setZrnijitoukeizennoukbn(String pZrnijitoukeizennoukbn) {
        getPrimaryKey().setZrnijitoukeizennoukbn(pZrnijitoukeizennoukbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNDAI1HKNKKN)
    public String getZrndai1hknkkn() {
        return getPrimaryKey().getZrndai1hknkkn();
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        getPrimaryKey().setZrndai1hknkkn(pZrndai1hknkkn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNIJITOUKEITIKSHRTKYKKBN)
    public String getZrnijitoukeitikshrtkykkbn() {
        return getPrimaryKey().getZrnijitoukeitikshrtkykkbn();
    }

    public void setZrnijitoukeitikshrtkykkbn(String pZrnijitoukeitikshrtkykkbn) {
        getPrimaryKey().setZrnijitoukeitikshrtkykkbn(pZrnijitoukeitikshrtkykkbn);
    }

    private String zrnyobiv31;

    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNYOBIV31)
    public String getZrnyobiv31() {
        return zrnyobiv31;
    }

    public void setZrnyobiv31(String pZrnyobiv31) {
        zrnyobiv31 = pZrnyobiv31;
    }

    private BizNumber zrnijitoukeikeikan;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNIJITOUKEIKEIKAN)
    public BizNumber getZrnijitoukeikeikan() {
        return zrnijitoukeikeikan;
    }

    public void setZrnijitoukeikeikan(BizNumber pZrnijitoukeikeikan) {
        zrnijitoukeikeikan = pZrnijitoukeikeikan;
    }

    private Integer zrnijitoukeisiboun;

    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNIJITOUKEISIBOUN)
    public Integer getZrnijitoukeisiboun() {
        return zrnijitoukeisiboun;
    }

    public void setZrnijitoukeisiboun(Integer pZrnijitoukeisiboun) {
        zrnijitoukeisiboun = pZrnijitoukeisiboun;
    }

    private BizNumber zrnijitoukeikeikas;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNIJITOUKEIKEIKAS)
    public BizNumber getZrnijitoukeikeikas() {
        return zrnijitoukeikeikas;
    }

    public void setZrnijitoukeikeikas(BizNumber pZrnijitoukeikeikas) {
        zrnijitoukeikeikas = pZrnijitoukeikeikas;
    }

    private Integer zrnijitoukeisibous;

    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNIJITOUKEISIBOUS)
    public Integer getZrnijitoukeisibous() {
        return zrnijitoukeisibous;
    }

    public void setZrnijitoukeisibous(Integer pZrnijitoukeisibous) {
        zrnijitoukeisibous = pZrnijitoukeisibous;
    }

    private String zrnyobiv20;

    @Column(name=GenZT_SyuHukugouSikkanDataRn.ZRNYOBIV20)
    public String getZrnyobiv20() {
        return zrnyobiv20;
    }

    public void setZrnyobiv20(String pZrnyobiv20) {
        zrnyobiv20 = pZrnyobiv20;
    }
}