package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.id.PKZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.meta.GenQZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.meta.QZT_SyuHukugouSikkanDataTy;

/**
 * 普保Ⅱ主契約複合疾患データテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SyuHukugouSikkanDataTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyuHukugouSikkanDataTy}</td><td colspan="3">普保Ⅱ主契約複合疾患データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyijitoukeidaihyousyurui ztyijitoukeidaihyousyurui}</td><td>（中継用）医事統計用代表種類</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakunendo ztykeiyakunendo}</td><td>（中継用）契約年度</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknnendo ztyhknnendo}</td><td>（中継用）保険年度</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykage ztykykage}</td><td>（中継用）加入年齢</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoutatunenrei ztytoutatunenrei}</td><td>（中継用）到達年齢</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatukaibetu ztyatukaibetu}</td><td>（中継用）扱別</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinsahouhou ztysinsahouhou}</td><td>（中継用）診査方法</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketteikekkakbn ztyketteikekkakbn}</td><td>（中継用）決定結果区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibousrank ztysibousrank}</td><td>（中継用）死亡Ｓランク</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjissituhosyousrank ztyjissituhosyousrank}</td><td>（中継用）実質保障Ｓランク</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysirajikykkbn ztysirajikykkbn}</td><td>（中継用）白地契約区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkhuhukbn ztyhrkhuhukbn}</td><td>（中継用）払込方法区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyurui2keta ztyhknsyurui2keta}</td><td>（中継用）保険種類（２桁）</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaisiincd ztydaisiincd}</td><td>（中継用）大死因コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuusiincd ztytyuusiincd}</td><td>（中継用）中死因コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyousiincd ztysyousiincd}</td><td>（中継用）小死因コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenreihousikikbn ztynenreihousikikbn}</td><td>（中継用）年令方式区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytodouhukencd ztytodouhukencd}</td><td>（中継用）都道府県コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybotaisisyaeigyouhonbu ztybotaisisyaeigyouhonbu}</td><td>（中継用）母体支社営業本部</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisyaeigyoubu ztysisyaeigyoubu}</td><td>（中継用）支社営業部</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisosikicd ztyaatukaisosikicd}</td><td>（中継用）Ａ扱者組織コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynensyuukbn ztynensyuukbn}</td><td>（中継用）年収区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhanbaikeirokbn ztyhanbaikeirokbn}</td><td>（中継用）販売経路区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyoyadairitencd ztyoyadairitencd}</td><td>（中継用）親代理店コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytratkidrtencd ztytratkidrtencd}</td><td>（中継用）取扱代理店コード</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktuuka ztykyktuuka}</td><td>（中継用）契約通貨</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrktuuka ztyhrktuuka}</td><td>（中継用）払込通貨</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyksbyensitihsyutyhkumu ztysyksbyensitihsyutyhkumu}</td><td>（中継用）初期死亡時円換算最低保証特約付加有無</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyudkaigomehrtkhkumu ztyjyudkaigomehrtkhkumu}</td><td>（中継用）重度介護前払特約付加有無</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyijitoukeizennoukbn ztyijitoukeizennoukbn}</td><td>（中継用）医事統計用前納区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1hknkkn ztydai1hknkkn}</td><td>（中継用）第１保険期間</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyijitoukeitikshrtkykkbn ztyijitoukeitikshrtkykkbn}</td><td>（中継用）医事統計用定期支払特約区分</td><td align="center">{@link PKZT_SyuHukugouSikkanDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv31 ztyyobiv31}</td><td>（中継用）予備項目Ｖ３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyijitoukeikeikan ztyijitoukeikeikan}</td><td>（中継用）医事統計用経過Ｎ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyijitoukeisiboun ztyijitoukeisiboun}</td><td>（中継用）医事統計用死亡Ｎ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyijitoukeikeikas ztyijitoukeikeikas}</td><td>（中継用）医事統計用経過Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyijitoukeisibous ztyijitoukeisibous}</td><td>（中継用）医事統計用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobiv20 ztyyobiv20}</td><td>（中継用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyuHukugouSikkanDataTy
 * @see     PKZT_SyuHukugouSikkanDataTy
 * @see     QZT_SyuHukugouSikkanDataTy
 * @see     GenQZT_SyuHukugouSikkanDataTy
 */
@MappedSuperclass
@Table(name=GenZT_SyuHukugouSikkanDataTy.TABLE_NAME)
@IdClass(value=PKZT_SyuHukugouSikkanDataTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SyuHukugouSikkanDataTy extends AbstractExDBEntity<ZT_SyuHukugouSikkanDataTy, PKZT_SyuHukugouSikkanDataTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyuHukugouSikkanDataTy";
    public static final String ZTYIJITOUKEIDAIHYOUSYURUI = "ztyijitoukeidaihyousyurui";
    public static final String ZTYKEIYAKUNENDO          = "ztykeiyakunendo";
    public static final String ZTYHKNNENDO              = "ztyhknnendo";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYKYKAGE                = "ztykykage";
    public static final String ZTYTOUTATUNENREI         = "ztytoutatunenrei";
    public static final String ZTYATUKAIBETU            = "ztyatukaibetu";
    public static final String ZTYSINSAHOUHOU           = "ztysinsahouhou";
    public static final String ZTYKETTEIKEKKAKBN        = "ztyketteikekkakbn";
    public static final String ZTYSIBOUSRANK            = "ztysibousrank";
    public static final String ZTYJISSITUHOSYOUSRANK    = "ztyjissituhosyousrank";
    public static final String ZTYSIRAJIKYKKBN          = "ztysirajikykkbn";
    public static final String ZTYHRKHUHUKBN            = "ztyhrkhuhukbn";
    public static final String ZTYHKNSYURUI2KETA        = "ztyhknsyurui2keta";
    public static final String ZTYDAISIINCD             = "ztydaisiincd";
    public static final String ZTYTYUUSIINCD            = "ztytyuusiincd";
    public static final String ZTYSYOUSIINCD            = "ztysyousiincd";
    public static final String ZTYNENREIHOUSIKIKBN      = "ztynenreihousikikbn";
    public static final String ZTYSYKGYCD               = "ztysykgycd";
    public static final String ZTYTODOUHUKENCD          = "ztytodouhukencd";
    public static final String ZTYBOTAISISYAEIGYOUHONBU = "ztybotaisisyaeigyouhonbu";
    public static final String ZTYSISYAEIGYOUBU         = "ztysisyaeigyoubu";
    public static final String ZTYAATUKAISOSIKICD       = "ztyaatukaisosikicd";
    public static final String ZTYNENSYUUKBN            = "ztynensyuukbn";
    public static final String ZTYHANBAIKEIROKBN        = "ztyhanbaikeirokbn";
    public static final String ZTYOYADAIRITENCD         = "ztyoyadairitencd";
    public static final String ZTYTRATKIDRTENCD         = "ztytratkidrtencd";
    public static final String ZTYBSUDIRTNATKIKEITAIKBN = "ztybsudirtnatkikeitaikbn";
    public static final String ZTYKYKTUUKA              = "ztykyktuuka";
    public static final String ZTYHRKTUUKA              = "ztyhrktuuka";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYSYKSBYENSITIHSYUTYHKUMU = "ztysyksbyensitihsyutyhkumu";
    public static final String ZTYJYUDKAIGOMEHRTKHKUMU  = "ztyjyudkaigomehrtkhkumu";
    public static final String ZTYIJITOUKEIZENNOUKBN    = "ztyijitoukeizennoukbn";
    public static final String ZTYDAI1HKNKKN            = "ztydai1hknkkn";
    public static final String ZTYIJITOUKEITIKSHRTKYKKBN = "ztyijitoukeitikshrtkykkbn";
    public static final String ZTYYOBIV31               = "ztyyobiv31";
    public static final String ZTYIJITOUKEIKEIKAN       = "ztyijitoukeikeikan";
    public static final String ZTYIJITOUKEISIBOUN       = "ztyijitoukeisiboun";
    public static final String ZTYIJITOUKEIKEIKAS       = "ztyijitoukeikeikas";
    public static final String ZTYIJITOUKEISIBOUS       = "ztyijitoukeisibous";
    public static final String ZTYYOBIV20               = "ztyyobiv20";

    private final PKZT_SyuHukugouSikkanDataTy primaryKey;

    public GenZT_SyuHukugouSikkanDataTy() {
        primaryKey = new PKZT_SyuHukugouSikkanDataTy();
    }

    public GenZT_SyuHukugouSikkanDataTy(
        String pZtyijitoukeidaihyousyurui,
        String pZtykeiyakunendo,
        String pZtyhknnendo,
        String pZtyhhknseikbn,
        String pZtykykage,
        String pZtytoutatunenrei,
        String pZtyatukaibetu,
        String pZtysinsahouhou,
        String pZtyketteikekkakbn,
        String pZtysibousrank,
        String pZtyjissituhosyousrank,
        String pZtysirajikykkbn,
        String pZtyhrkhuhukbn,
        String pZtyhknsyurui2keta,
        String pZtydaisiincd,
        String pZtytyuusiincd,
        String pZtysyousiincd,
        String pZtynenreihousikikbn,
        String pZtysykgycd,
        String pZtytodouhukencd,
        String pZtybotaisisyaeigyouhonbu,
        String pZtysisyaeigyoubu,
        String pZtyaatukaisosikicd,
        String pZtynensyuukbn,
        String pZtyhanbaikeirokbn,
        String pZtyoyadairitencd,
        String pZtytratkidrtencd,
        String pZtybsudirtnatkikeitaikbn,
        String pZtykyktuuka,
        String pZtyhrktuuka,
        String pZtyhknsyukigou,
        String pZtysyksbyensitihsyutyhkumu,
        String pZtyjyudkaigomehrtkhkumu,
        String pZtyijitoukeizennoukbn,
        String pZtydai1hknkkn,
        String pZtyijitoukeitikshrtkykkbn
    ) {
        primaryKey = new PKZT_SyuHukugouSikkanDataTy(
            pZtyijitoukeidaihyousyurui,
            pZtykeiyakunendo,
            pZtyhknnendo,
            pZtyhhknseikbn,
            pZtykykage,
            pZtytoutatunenrei,
            pZtyatukaibetu,
            pZtysinsahouhou,
            pZtyketteikekkakbn,
            pZtysibousrank,
            pZtyjissituhosyousrank,
            pZtysirajikykkbn,
            pZtyhrkhuhukbn,
            pZtyhknsyurui2keta,
            pZtydaisiincd,
            pZtytyuusiincd,
            pZtysyousiincd,
            pZtynenreihousikikbn,
            pZtysykgycd,
            pZtytodouhukencd,
            pZtybotaisisyaeigyouhonbu,
            pZtysisyaeigyoubu,
            pZtyaatukaisosikicd,
            pZtynensyuukbn,
            pZtyhanbaikeirokbn,
            pZtyoyadairitencd,
            pZtytratkidrtencd,
            pZtybsudirtnatkikeitaikbn,
            pZtykyktuuka,
            pZtyhrktuuka,
            pZtyhknsyukigou,
            pZtysyksbyensitihsyutyhkumu,
            pZtyjyudkaigomehrtkhkumu,
            pZtyijitoukeizennoukbn,
            pZtydai1hknkkn,
            pZtyijitoukeitikshrtkykkbn
        );
    }

    @Transient
    @Override
    public PKZT_SyuHukugouSikkanDataTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyuHukugouSikkanDataTy> getMetaClass() {
        return QZT_SyuHukugouSikkanDataTy.class;
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYIJITOUKEIDAIHYOUSYURUI)
    public String getZtyijitoukeidaihyousyurui() {
        return getPrimaryKey().getZtyijitoukeidaihyousyurui();
    }

    public void setZtyijitoukeidaihyousyurui(String pZtyijitoukeidaihyousyurui) {
        getPrimaryKey().setZtyijitoukeidaihyousyurui(pZtyijitoukeidaihyousyurui);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYKEIYAKUNENDO)
    public String getZtykeiyakunendo() {
        return getPrimaryKey().getZtykeiyakunendo();
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        getPrimaryKey().setZtykeiyakunendo(pZtykeiyakunendo);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYHKNNENDO)
    public String getZtyhknnendo() {
        return getPrimaryKey().getZtyhknnendo();
    }

    public void setZtyhknnendo(String pZtyhknnendo) {
        getPrimaryKey().setZtyhknnendo(pZtyhknnendo);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return getPrimaryKey().getZtyhhknseikbn();
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        getPrimaryKey().setZtyhhknseikbn(pZtyhhknseikbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYKYKAGE)
    public String getZtykykage() {
        return getPrimaryKey().getZtykykage();
    }

    public void setZtykykage(String pZtykykage) {
        getPrimaryKey().setZtykykage(pZtykykage);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYTOUTATUNENREI)
    public String getZtytoutatunenrei() {
        return getPrimaryKey().getZtytoutatunenrei();
    }

    public void setZtytoutatunenrei(String pZtytoutatunenrei) {
        getPrimaryKey().setZtytoutatunenrei(pZtytoutatunenrei);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYATUKAIBETU)
    public String getZtyatukaibetu() {
        return getPrimaryKey().getZtyatukaibetu();
    }

    public void setZtyatukaibetu(String pZtyatukaibetu) {
        getPrimaryKey().setZtyatukaibetu(pZtyatukaibetu);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYSINSAHOUHOU)
    public String getZtysinsahouhou() {
        return getPrimaryKey().getZtysinsahouhou();
    }

    public void setZtysinsahouhou(String pZtysinsahouhou) {
        getPrimaryKey().setZtysinsahouhou(pZtysinsahouhou);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYKETTEIKEKKAKBN)
    public String getZtyketteikekkakbn() {
        return getPrimaryKey().getZtyketteikekkakbn();
    }

    public void setZtyketteikekkakbn(String pZtyketteikekkakbn) {
        getPrimaryKey().setZtyketteikekkakbn(pZtyketteikekkakbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYSIBOUSRANK)
    public String getZtysibousrank() {
        return getPrimaryKey().getZtysibousrank();
    }

    public void setZtysibousrank(String pZtysibousrank) {
        getPrimaryKey().setZtysibousrank(pZtysibousrank);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYJISSITUHOSYOUSRANK)
    public String getZtyjissituhosyousrank() {
        return getPrimaryKey().getZtyjissituhosyousrank();
    }

    public void setZtyjissituhosyousrank(String pZtyjissituhosyousrank) {
        getPrimaryKey().setZtyjissituhosyousrank(pZtyjissituhosyousrank);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYSIRAJIKYKKBN)
    public String getZtysirajikykkbn() {
        return getPrimaryKey().getZtysirajikykkbn();
    }

    public void setZtysirajikykkbn(String pZtysirajikykkbn) {
        getPrimaryKey().setZtysirajikykkbn(pZtysirajikykkbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYHRKHUHUKBN)
    public String getZtyhrkhuhukbn() {
        return getPrimaryKey().getZtyhrkhuhukbn();
    }

    public void setZtyhrkhuhukbn(String pZtyhrkhuhukbn) {
        getPrimaryKey().setZtyhrkhuhukbn(pZtyhrkhuhukbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYHKNSYURUI2KETA)
    public String getZtyhknsyurui2keta() {
        return getPrimaryKey().getZtyhknsyurui2keta();
    }

    public void setZtyhknsyurui2keta(String pZtyhknsyurui2keta) {
        getPrimaryKey().setZtyhknsyurui2keta(pZtyhknsyurui2keta);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYDAISIINCD)
    public String getZtydaisiincd() {
        return getPrimaryKey().getZtydaisiincd();
    }

    public void setZtydaisiincd(String pZtydaisiincd) {
        getPrimaryKey().setZtydaisiincd(pZtydaisiincd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYTYUUSIINCD)
    public String getZtytyuusiincd() {
        return getPrimaryKey().getZtytyuusiincd();
    }

    public void setZtytyuusiincd(String pZtytyuusiincd) {
        getPrimaryKey().setZtytyuusiincd(pZtytyuusiincd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYSYOUSIINCD)
    public String getZtysyousiincd() {
        return getPrimaryKey().getZtysyousiincd();
    }

    public void setZtysyousiincd(String pZtysyousiincd) {
        getPrimaryKey().setZtysyousiincd(pZtysyousiincd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYNENREIHOUSIKIKBN)
    public String getZtynenreihousikikbn() {
        return getPrimaryKey().getZtynenreihousikikbn();
    }

    public void setZtynenreihousikikbn(String pZtynenreihousikikbn) {
        getPrimaryKey().setZtynenreihousikikbn(pZtynenreihousikikbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return getPrimaryKey().getZtysykgycd();
    }

    public void setZtysykgycd(String pZtysykgycd) {
        getPrimaryKey().setZtysykgycd(pZtysykgycd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYTODOUHUKENCD)
    public String getZtytodouhukencd() {
        return getPrimaryKey().getZtytodouhukencd();
    }

    public void setZtytodouhukencd(String pZtytodouhukencd) {
        getPrimaryKey().setZtytodouhukencd(pZtytodouhukencd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYBOTAISISYAEIGYOUHONBU)
    public String getZtybotaisisyaeigyouhonbu() {
        return getPrimaryKey().getZtybotaisisyaeigyouhonbu();
    }

    public void setZtybotaisisyaeigyouhonbu(String pZtybotaisisyaeigyouhonbu) {
        getPrimaryKey().setZtybotaisisyaeigyouhonbu(pZtybotaisisyaeigyouhonbu);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYSISYAEIGYOUBU)
    public String getZtysisyaeigyoubu() {
        return getPrimaryKey().getZtysisyaeigyoubu();
    }

    public void setZtysisyaeigyoubu(String pZtysisyaeigyoubu) {
        getPrimaryKey().setZtysisyaeigyoubu(pZtysisyaeigyoubu);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYAATUKAISOSIKICD)
    public String getZtyaatukaisosikicd() {
        return getPrimaryKey().getZtyaatukaisosikicd();
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        getPrimaryKey().setZtyaatukaisosikicd(pZtyaatukaisosikicd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYNENSYUUKBN)
    public String getZtynensyuukbn() {
        return getPrimaryKey().getZtynensyuukbn();
    }

    public void setZtynensyuukbn(String pZtynensyuukbn) {
        getPrimaryKey().setZtynensyuukbn(pZtynensyuukbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYHANBAIKEIROKBN)
    public String getZtyhanbaikeirokbn() {
        return getPrimaryKey().getZtyhanbaikeirokbn();
    }

    public void setZtyhanbaikeirokbn(String pZtyhanbaikeirokbn) {
        getPrimaryKey().setZtyhanbaikeirokbn(pZtyhanbaikeirokbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYOYADAIRITENCD)
    public String getZtyoyadairitencd() {
        return getPrimaryKey().getZtyoyadairitencd();
    }

    public void setZtyoyadairitencd(String pZtyoyadairitencd) {
        getPrimaryKey().setZtyoyadairitencd(pZtyoyadairitencd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYTRATKIDRTENCD)
    public String getZtytratkidrtencd() {
        return getPrimaryKey().getZtytratkidrtencd();
    }

    public void setZtytratkidrtencd(String pZtytratkidrtencd) {
        getPrimaryKey().setZtytratkidrtencd(pZtytratkidrtencd);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYBSUDIRTNATKIKEITAIKBN)
    public String getZtybsudirtnatkikeitaikbn() {
        return getPrimaryKey().getZtybsudirtnatkikeitaikbn();
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        getPrimaryKey().setZtybsudirtnatkikeitaikbn(pZtybsudirtnatkikeitaikbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYKYKTUUKA)
    public String getZtykyktuuka() {
        return getPrimaryKey().getZtykyktuuka();
    }

    public void setZtykyktuuka(String pZtykyktuuka) {
        getPrimaryKey().setZtykyktuuka(pZtykyktuuka);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYHRKTUUKA)
    public String getZtyhrktuuka() {
        return getPrimaryKey().getZtyhrktuuka();
    }

    public void setZtyhrktuuka(String pZtyhrktuuka) {
        getPrimaryKey().setZtyhrktuuka(pZtyhrktuuka);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return getPrimaryKey().getZtyhknsyukigou();
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        getPrimaryKey().setZtyhknsyukigou(pZtyhknsyukigou);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYSYKSBYENSITIHSYUTYHKUMU)
    public String getZtysyksbyensitihsyutyhkumu() {
        return getPrimaryKey().getZtysyksbyensitihsyutyhkumu();
    }

    public void setZtysyksbyensitihsyutyhkumu(String pZtysyksbyensitihsyutyhkumu) {
        getPrimaryKey().setZtysyksbyensitihsyutyhkumu(pZtysyksbyensitihsyutyhkumu);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYJYUDKAIGOMEHRTKHKUMU)
    public String getZtyjyudkaigomehrtkhkumu() {
        return getPrimaryKey().getZtyjyudkaigomehrtkhkumu();
    }

    public void setZtyjyudkaigomehrtkhkumu(String pZtyjyudkaigomehrtkhkumu) {
        getPrimaryKey().setZtyjyudkaigomehrtkhkumu(pZtyjyudkaigomehrtkhkumu);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYIJITOUKEIZENNOUKBN)
    public String getZtyijitoukeizennoukbn() {
        return getPrimaryKey().getZtyijitoukeizennoukbn();
    }

    public void setZtyijitoukeizennoukbn(String pZtyijitoukeizennoukbn) {
        getPrimaryKey().setZtyijitoukeizennoukbn(pZtyijitoukeizennoukbn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYDAI1HKNKKN)
    public String getZtydai1hknkkn() {
        return getPrimaryKey().getZtydai1hknkkn();
    }

    public void setZtydai1hknkkn(String pZtydai1hknkkn) {
        getPrimaryKey().setZtydai1hknkkn(pZtydai1hknkkn);
    }

    @Id
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYIJITOUKEITIKSHRTKYKKBN)
    public String getZtyijitoukeitikshrtkykkbn() {
        return getPrimaryKey().getZtyijitoukeitikshrtkykkbn();
    }

    public void setZtyijitoukeitikshrtkykkbn(String pZtyijitoukeitikshrtkykkbn) {
        getPrimaryKey().setZtyijitoukeitikshrtkykkbn(pZtyijitoukeitikshrtkykkbn);
    }

    private String ztyyobiv31;

    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYYOBIV31)
    public String getZtyyobiv31() {
        return ztyyobiv31;
    }

    public void setZtyyobiv31(String pZtyyobiv31) {
        ztyyobiv31 = pZtyyobiv31;
    }

    private BizNumber ztyijitoukeikeikan;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYIJITOUKEIKEIKAN)
    public BizNumber getZtyijitoukeikeikan() {
        return ztyijitoukeikeikan;
    }

    public void setZtyijitoukeikeikan(BizNumber pZtyijitoukeikeikan) {
        ztyijitoukeikeikan = pZtyijitoukeikeikan;
    }

    private Integer ztyijitoukeisiboun;

    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYIJITOUKEISIBOUN)
    public Integer getZtyijitoukeisiboun() {
        return ztyijitoukeisiboun;
    }

    public void setZtyijitoukeisiboun(Integer pZtyijitoukeisiboun) {
        ztyijitoukeisiboun = pZtyijitoukeisiboun;
    }

    private BizNumber ztyijitoukeikeikas;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYIJITOUKEIKEIKAS)
    public BizNumber getZtyijitoukeikeikas() {
        return ztyijitoukeikeikas;
    }

    public void setZtyijitoukeikeikas(BizNumber pZtyijitoukeikeikas) {
        ztyijitoukeikeikas = pZtyijitoukeikeikas;
    }

    private Integer ztyijitoukeisibous;

    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYIJITOUKEISIBOUS)
    public Integer getZtyijitoukeisibous() {
        return ztyijitoukeisibous;
    }

    public void setZtyijitoukeisibous(Integer pZtyijitoukeisibous) {
        ztyijitoukeisibous = pZtyijitoukeisibous;
    }

    private String ztyyobiv20;

    @Column(name=GenZT_SyuHukugouSikkanDataTy.ZTYYOBIV20)
    public String getZtyyobiv20() {
        return ztyyobiv20;
    }

    public void setZtyyobiv20(String pZtyyobiv20) {
        ztyyobiv20 = pZtyyobiv20;
    }
}