package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.mapping.GenZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.meta.GenQZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.meta.QZT_SyuHukugouSikkanDataRn;

/**
 * 普保Ⅱ主契約複合疾患データテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyuHukugouSikkanDataRn}</td><td colspan="3">普保Ⅱ主契約複合疾患データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnijitoukeidaihyousyurui zrnijitoukeidaihyousyurui}</td><td>（連携用）医事統計用代表種類</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkeiyakunendo zrnkeiyakunendo}</td><td>（連携用）契約年度</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknnendo zrnhknnendo}</td><td>（連携用）保険年度</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkykage zrnkykage}</td><td>（連携用）加入年齢</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntoutatunenrei zrntoutatunenrei}</td><td>（連携用）到達年齢</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnatukaibetu zrnatukaibetu}</td><td>（連携用）扱別</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsinsahouhou zrnsinsahouhou}</td><td>（連携用）診査方法</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnketteikekkakbn zrnketteikekkakbn}</td><td>（連携用）決定結果区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsibousrank zrnsibousrank}</td><td>（連携用）死亡Ｓランク</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnjissituhosyousrank zrnjissituhosyousrank}</td><td>（連携用）実質保障Ｓランク</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsirajikykkbn zrnsirajikykkbn}</td><td>（連携用）白地契約区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhrkhuhukbn zrnhrkhuhukbn}</td><td>（連携用）払込方法区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknsyurui2keta zrnhknsyurui2keta}</td><td>（連携用）保険種類（２桁）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndaisiincd zrndaisiincd}</td><td>（連携用）大死因コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyuusiincd zrntyuusiincd}</td><td>（連携用）中死因コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyousiincd zrnsyousiincd}</td><td>（連携用）小死因コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnenreihousikikbn zrnnenreihousikikbn}</td><td>（連携用）年令方式区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntodouhukencd zrntodouhukencd}</td><td>（連携用）都道府県コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbotaisisyaeigyouhonbu zrnbotaisisyaeigyouhonbu}</td><td>（連携用）母体支社営業本部</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsisyaeigyoubu zrnsisyaeigyoubu}</td><td>（連携用）支社営業部</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnaatukaisosikicd zrnaatukaisosikicd}</td><td>（連携用）Ａ扱者組織コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnensyuukbn zrnnensyuukbn}</td><td>（連携用）年収区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhanbaikeirokbn zrnhanbaikeirokbn}</td><td>（連携用）販売経路区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnoyadairitencd zrnoyadairitencd}</td><td>（連携用）親代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntratkidrtencd zrntratkidrtencd}</td><td>（連携用）取扱代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkyktuuka zrnkyktuuka}</td><td>（連携用）契約通貨</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhrktuuka zrnhrktuuka}</td><td>（連携用）払込通貨</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyksbyensitihsyutyhkumu zrnsyksbyensitihsyutyhkumu}</td><td>（連携用）初期死亡時円換算最低保証特約付加有無</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnjyudkaigomehrtkhkumu zrnjyudkaigomehrtkhkumu}</td><td>（連携用）重度介護前払特約付加有無</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnijitoukeizennoukbn zrnijitoukeizennoukbn}</td><td>（連携用）医事統計用前納区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnijitoukeitikshrtkykkbn zrnijitoukeitikshrtkykkbn}</td><td>（連携用）医事統計用定期支払特約区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv31</td><td>（連携用）予備項目Ｖ３１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnijitoukeikeikan</td><td>（連携用）医事統計用経過Ｎ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnijitoukeisiboun</td><td>（連携用）医事統計用死亡Ｎ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnijitoukeikeikas</td><td>（連携用）医事統計用経過Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnijitoukeisibous</td><td>（連携用）医事統計用死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyobiv20</td><td>（連携用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyuHukugouSikkanDataRn
 * @see     GenZT_SyuHukugouSikkanDataRn
 * @see     QZT_SyuHukugouSikkanDataRn
 * @see     GenQZT_SyuHukugouSikkanDataRn
 */
public class PKZT_SyuHukugouSikkanDataRn extends AbstractExDBPrimaryKey<ZT_SyuHukugouSikkanDataRn, PKZT_SyuHukugouSikkanDataRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SyuHukugouSikkanDataRn() {
    }

    public PKZT_SyuHukugouSikkanDataRn(
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
        zrnijitoukeidaihyousyurui = pZrnijitoukeidaihyousyurui;
        zrnkeiyakunendo = pZrnkeiyakunendo;
        zrnhknnendo = pZrnhknnendo;
        zrnhhknseikbn = pZrnhhknseikbn;
        zrnkykage = pZrnkykage;
        zrntoutatunenrei = pZrntoutatunenrei;
        zrnatukaibetu = pZrnatukaibetu;
        zrnsinsahouhou = pZrnsinsahouhou;
        zrnketteikekkakbn = pZrnketteikekkakbn;
        zrnsibousrank = pZrnsibousrank;
        zrnjissituhosyousrank = pZrnjissituhosyousrank;
        zrnsirajikykkbn = pZrnsirajikykkbn;
        zrnhrkhuhukbn = pZrnhrkhuhukbn;
        zrnhknsyurui2keta = pZrnhknsyurui2keta;
        zrndaisiincd = pZrndaisiincd;
        zrntyuusiincd = pZrntyuusiincd;
        zrnsyousiincd = pZrnsyousiincd;
        zrnnenreihousikikbn = pZrnnenreihousikikbn;
        zrnsykgycd = pZrnsykgycd;
        zrntodouhukencd = pZrntodouhukencd;
        zrnbotaisisyaeigyouhonbu = pZrnbotaisisyaeigyouhonbu;
        zrnsisyaeigyoubu = pZrnsisyaeigyoubu;
        zrnaatukaisosikicd = pZrnaatukaisosikicd;
        zrnnensyuukbn = pZrnnensyuukbn;
        zrnhanbaikeirokbn = pZrnhanbaikeirokbn;
        zrnoyadairitencd = pZrnoyadairitencd;
        zrntratkidrtencd = pZrntratkidrtencd;
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
        zrnkyktuuka = pZrnkyktuuka;
        zrnhrktuuka = pZrnhrktuuka;
        zrnhknsyukigou = pZrnhknsyukigou;
        zrnsyksbyensitihsyutyhkumu = pZrnsyksbyensitihsyutyhkumu;
        zrnjyudkaigomehrtkhkumu = pZrnjyudkaigomehrtkhkumu;
        zrnijitoukeizennoukbn = pZrnijitoukeizennoukbn;
        zrndai1hknkkn = pZrndai1hknkkn;
        zrnijitoukeitikshrtkykkbn = pZrnijitoukeitikshrtkykkbn;
    }

    @Transient
    @Override
    public Class<ZT_SyuHukugouSikkanDataRn> getEntityClass() {
        return ZT_SyuHukugouSikkanDataRn.class;
    }

    private String zrnijitoukeidaihyousyurui;

    public String getZrnijitoukeidaihyousyurui() {
        return zrnijitoukeidaihyousyurui;
    }

    public void setZrnijitoukeidaihyousyurui(String pZrnijitoukeidaihyousyurui) {
        zrnijitoukeidaihyousyurui = pZrnijitoukeidaihyousyurui;
    }
    private String zrnkeiyakunendo;

    public String getZrnkeiyakunendo() {
        return zrnkeiyakunendo;
    }

    public void setZrnkeiyakunendo(String pZrnkeiyakunendo) {
        zrnkeiyakunendo = pZrnkeiyakunendo;
    }
    private String zrnhknnendo;

    public String getZrnhknnendo() {
        return zrnhknnendo;
    }

    public void setZrnhknnendo(String pZrnhknnendo) {
        zrnhknnendo = pZrnhknnendo;
    }
    private String zrnhhknseikbn;

    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }
    private String zrnkykage;

    public String getZrnkykage() {
        return zrnkykage;
    }

    public void setZrnkykage(String pZrnkykage) {
        zrnkykage = pZrnkykage;
    }
    private String zrntoutatunenrei;

    public String getZrntoutatunenrei() {
        return zrntoutatunenrei;
    }

    public void setZrntoutatunenrei(String pZrntoutatunenrei) {
        zrntoutatunenrei = pZrntoutatunenrei;
    }
    private String zrnatukaibetu;

    public String getZrnatukaibetu() {
        return zrnatukaibetu;
    }

    public void setZrnatukaibetu(String pZrnatukaibetu) {
        zrnatukaibetu = pZrnatukaibetu;
    }
    private String zrnsinsahouhou;

    public String getZrnsinsahouhou() {
        return zrnsinsahouhou;
    }

    public void setZrnsinsahouhou(String pZrnsinsahouhou) {
        zrnsinsahouhou = pZrnsinsahouhou;
    }
    private String zrnketteikekkakbn;

    public String getZrnketteikekkakbn() {
        return zrnketteikekkakbn;
    }

    public void setZrnketteikekkakbn(String pZrnketteikekkakbn) {
        zrnketteikekkakbn = pZrnketteikekkakbn;
    }
    private String zrnsibousrank;

    public String getZrnsibousrank() {
        return zrnsibousrank;
    }

    public void setZrnsibousrank(String pZrnsibousrank) {
        zrnsibousrank = pZrnsibousrank;
    }
    private String zrnjissituhosyousrank;

    public String getZrnjissituhosyousrank() {
        return zrnjissituhosyousrank;
    }

    public void setZrnjissituhosyousrank(String pZrnjissituhosyousrank) {
        zrnjissituhosyousrank = pZrnjissituhosyousrank;
    }
    private String zrnsirajikykkbn;

    public String getZrnsirajikykkbn() {
        return zrnsirajikykkbn;
    }

    public void setZrnsirajikykkbn(String pZrnsirajikykkbn) {
        zrnsirajikykkbn = pZrnsirajikykkbn;
    }
    private String zrnhrkhuhukbn;

    public String getZrnhrkhuhukbn() {
        return zrnhrkhuhukbn;
    }

    public void setZrnhrkhuhukbn(String pZrnhrkhuhukbn) {
        zrnhrkhuhukbn = pZrnhrkhuhukbn;
    }
    private String zrnhknsyurui2keta;

    public String getZrnhknsyurui2keta() {
        return zrnhknsyurui2keta;
    }

    public void setZrnhknsyurui2keta(String pZrnhknsyurui2keta) {
        zrnhknsyurui2keta = pZrnhknsyurui2keta;
    }
    private String zrndaisiincd;

    public String getZrndaisiincd() {
        return zrndaisiincd;
    }

    public void setZrndaisiincd(String pZrndaisiincd) {
        zrndaisiincd = pZrndaisiincd;
    }
    private String zrntyuusiincd;

    public String getZrntyuusiincd() {
        return zrntyuusiincd;
    }

    public void setZrntyuusiincd(String pZrntyuusiincd) {
        zrntyuusiincd = pZrntyuusiincd;
    }
    private String zrnsyousiincd;

    public String getZrnsyousiincd() {
        return zrnsyousiincd;
    }

    public void setZrnsyousiincd(String pZrnsyousiincd) {
        zrnsyousiincd = pZrnsyousiincd;
    }
    private String zrnnenreihousikikbn;

    public String getZrnnenreihousikikbn() {
        return zrnnenreihousikikbn;
    }

    public void setZrnnenreihousikikbn(String pZrnnenreihousikikbn) {
        zrnnenreihousikikbn = pZrnnenreihousikikbn;
    }
    private String zrnsykgycd;

    public String getZrnsykgycd() {
        return zrnsykgycd;
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        zrnsykgycd = pZrnsykgycd;
    }
    private String zrntodouhukencd;

    public String getZrntodouhukencd() {
        return zrntodouhukencd;
    }

    public void setZrntodouhukencd(String pZrntodouhukencd) {
        zrntodouhukencd = pZrntodouhukencd;
    }
    private String zrnbotaisisyaeigyouhonbu;

    public String getZrnbotaisisyaeigyouhonbu() {
        return zrnbotaisisyaeigyouhonbu;
    }

    public void setZrnbotaisisyaeigyouhonbu(String pZrnbotaisisyaeigyouhonbu) {
        zrnbotaisisyaeigyouhonbu = pZrnbotaisisyaeigyouhonbu;
    }
    private String zrnsisyaeigyoubu;

    public String getZrnsisyaeigyoubu() {
        return zrnsisyaeigyoubu;
    }

    public void setZrnsisyaeigyoubu(String pZrnsisyaeigyoubu) {
        zrnsisyaeigyoubu = pZrnsisyaeigyoubu;
    }
    private String zrnaatukaisosikicd;

    public String getZrnaatukaisosikicd() {
        return zrnaatukaisosikicd;
    }

    public void setZrnaatukaisosikicd(String pZrnaatukaisosikicd) {
        zrnaatukaisosikicd = pZrnaatukaisosikicd;
    }
    private String zrnnensyuukbn;

    public String getZrnnensyuukbn() {
        return zrnnensyuukbn;
    }

    public void setZrnnensyuukbn(String pZrnnensyuukbn) {
        zrnnensyuukbn = pZrnnensyuukbn;
    }
    private String zrnhanbaikeirokbn;

    public String getZrnhanbaikeirokbn() {
        return zrnhanbaikeirokbn;
    }

    public void setZrnhanbaikeirokbn(String pZrnhanbaikeirokbn) {
        zrnhanbaikeirokbn = pZrnhanbaikeirokbn;
    }
    private String zrnoyadairitencd;

    public String getZrnoyadairitencd() {
        return zrnoyadairitencd;
    }

    public void setZrnoyadairitencd(String pZrnoyadairitencd) {
        zrnoyadairitencd = pZrnoyadairitencd;
    }
    private String zrntratkidrtencd;

    public String getZrntratkidrtencd() {
        return zrntratkidrtencd;
    }

    public void setZrntratkidrtencd(String pZrntratkidrtencd) {
        zrntratkidrtencd = pZrntratkidrtencd;
    }
    private String zrnbsudirtnatkikeitaikbn;

    public String getZrnbsudirtnatkikeitaikbn() {
        return zrnbsudirtnatkikeitaikbn;
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
    }
    private String zrnkyktuuka;

    public String getZrnkyktuuka() {
        return zrnkyktuuka;
    }

    public void setZrnkyktuuka(String pZrnkyktuuka) {
        zrnkyktuuka = pZrnkyktuuka;
    }
    private String zrnhrktuuka;

    public String getZrnhrktuuka() {
        return zrnhrktuuka;
    }

    public void setZrnhrktuuka(String pZrnhrktuuka) {
        zrnhrktuuka = pZrnhrktuuka;
    }
    private String zrnhknsyukigou;

    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }
    private String zrnsyksbyensitihsyutyhkumu;

    public String getZrnsyksbyensitihsyutyhkumu() {
        return zrnsyksbyensitihsyutyhkumu;
    }

    public void setZrnsyksbyensitihsyutyhkumu(String pZrnsyksbyensitihsyutyhkumu) {
        zrnsyksbyensitihsyutyhkumu = pZrnsyksbyensitihsyutyhkumu;
    }
    private String zrnjyudkaigomehrtkhkumu;

    public String getZrnjyudkaigomehrtkhkumu() {
        return zrnjyudkaigomehrtkhkumu;
    }

    public void setZrnjyudkaigomehrtkhkumu(String pZrnjyudkaigomehrtkhkumu) {
        zrnjyudkaigomehrtkhkumu = pZrnjyudkaigomehrtkhkumu;
    }
    private String zrnijitoukeizennoukbn;

    public String getZrnijitoukeizennoukbn() {
        return zrnijitoukeizennoukbn;
    }

    public void setZrnijitoukeizennoukbn(String pZrnijitoukeizennoukbn) {
        zrnijitoukeizennoukbn = pZrnijitoukeizennoukbn;
    }
    private String zrndai1hknkkn;

    public String getZrndai1hknkkn() {
        return zrndai1hknkkn;
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        zrndai1hknkkn = pZrndai1hknkkn;
    }
    private String zrnijitoukeitikshrtkykkbn;

    public String getZrnijitoukeitikshrtkykkbn() {
        return zrnijitoukeitikshrtkykkbn;
    }

    public void setZrnijitoukeitikshrtkykkbn(String pZrnijitoukeitikshrtkykkbn) {
        zrnijitoukeitikshrtkykkbn = pZrnijitoukeitikshrtkykkbn;
    }

}