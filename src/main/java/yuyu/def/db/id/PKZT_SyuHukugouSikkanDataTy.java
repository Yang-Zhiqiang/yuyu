package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.mapping.GenZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.meta.GenQZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.meta.QZT_SyuHukugouSikkanDataTy;

/**
 * 普保Ⅱ主契約複合疾患データテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyuHukugouSikkanDataTy}</td><td colspan="3">普保Ⅱ主契約複合疾患データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyijitoukeidaihyousyurui ztyijitoukeidaihyousyurui}</td><td>（中継用）医事統計用代表種類</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykeiyakunendo ztykeiyakunendo}</td><td>（中継用）契約年度</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhknnendo ztyhknnendo}</td><td>（中継用）保険年度</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykykage ztykykage}</td><td>（中継用）加入年齢</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytoutatunenrei ztytoutatunenrei}</td><td>（中継用）到達年齢</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyatukaibetu ztyatukaibetu}</td><td>（中継用）扱別</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysinsahouhou ztysinsahouhou}</td><td>（中継用）診査方法</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyketteikekkakbn ztyketteikekkakbn}</td><td>（中継用）決定結果区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysibousrank ztysibousrank}</td><td>（中継用）死亡Ｓランク</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyjissituhosyousrank ztyjissituhosyousrank}</td><td>（中継用）実質保障Ｓランク</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysirajikykkbn ztysirajikykkbn}</td><td>（中継用）白地契約区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhrkhuhukbn ztyhrkhuhukbn}</td><td>（中継用）払込方法区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhknsyurui2keta ztyhknsyurui2keta}</td><td>（中継用）保険種類（２桁）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydaisiincd ztydaisiincd}</td><td>（中継用）大死因コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyuusiincd ztytyuusiincd}</td><td>（中継用）中死因コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyousiincd ztysyousiincd}</td><td>（中継用）小死因コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtynenreihousikikbn ztynenreihousikikbn}</td><td>（中継用）年令方式区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytodouhukencd ztytodouhukencd}</td><td>（中継用）都道府県コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybotaisisyaeigyouhonbu ztybotaisisyaeigyouhonbu}</td><td>（中継用）母体支社営業本部</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysisyaeigyoubu ztysisyaeigyoubu}</td><td>（中継用）支社営業部</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyaatukaisosikicd ztyaatukaisosikicd}</td><td>（中継用）Ａ扱者組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtynensyuukbn ztynensyuukbn}</td><td>（中継用）年収区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhanbaikeirokbn ztyhanbaikeirokbn}</td><td>（中継用）販売経路区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyoyadairitencd ztyoyadairitencd}</td><td>（中継用）親代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytratkidrtencd ztytratkidrtencd}</td><td>（中継用）取扱代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykyktuuka ztykyktuuka}</td><td>（中継用）契約通貨</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhrktuuka ztyhrktuuka}</td><td>（中継用）払込通貨</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyksbyensitihsyutyhkumu ztysyksbyensitihsyutyhkumu}</td><td>（中継用）初期死亡時円換算最低保証特約付加有無</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyjyudkaigomehrtkhkumu ztyjyudkaigomehrtkhkumu}</td><td>（中継用）重度介護前払特約付加有無</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyijitoukeizennoukbn ztyijitoukeizennoukbn}</td><td>（中継用）医事統計用前納区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydai1hknkkn ztydai1hknkkn}</td><td>（中継用）第１保険期間</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyijitoukeitikshrtkykkbn ztyijitoukeitikshrtkykkbn}</td><td>（中継用）医事統計用定期支払特約区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv31</td><td>（中継用）予備項目Ｖ３１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyijitoukeikeikan</td><td>（中継用）医事統計用経過Ｎ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyijitoukeisiboun</td><td>（中継用）医事統計用死亡Ｎ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyijitoukeikeikas</td><td>（中継用）医事統計用経過Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyijitoukeisibous</td><td>（中継用）医事統計用死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobiv20</td><td>（中継用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyuHukugouSikkanDataTy
 * @see     GenZT_SyuHukugouSikkanDataTy
 * @see     QZT_SyuHukugouSikkanDataTy
 * @see     GenQZT_SyuHukugouSikkanDataTy
 */
public class PKZT_SyuHukugouSikkanDataTy extends AbstractExDBPrimaryKey<ZT_SyuHukugouSikkanDataTy, PKZT_SyuHukugouSikkanDataTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SyuHukugouSikkanDataTy() {
    }

    public PKZT_SyuHukugouSikkanDataTy(
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
        ztyijitoukeidaihyousyurui = pZtyijitoukeidaihyousyurui;
        ztykeiyakunendo = pZtykeiyakunendo;
        ztyhknnendo = pZtyhknnendo;
        ztyhhknseikbn = pZtyhhknseikbn;
        ztykykage = pZtykykage;
        ztytoutatunenrei = pZtytoutatunenrei;
        ztyatukaibetu = pZtyatukaibetu;
        ztysinsahouhou = pZtysinsahouhou;
        ztyketteikekkakbn = pZtyketteikekkakbn;
        ztysibousrank = pZtysibousrank;
        ztyjissituhosyousrank = pZtyjissituhosyousrank;
        ztysirajikykkbn = pZtysirajikykkbn;
        ztyhrkhuhukbn = pZtyhrkhuhukbn;
        ztyhknsyurui2keta = pZtyhknsyurui2keta;
        ztydaisiincd = pZtydaisiincd;
        ztytyuusiincd = pZtytyuusiincd;
        ztysyousiincd = pZtysyousiincd;
        ztynenreihousikikbn = pZtynenreihousikikbn;
        ztysykgycd = pZtysykgycd;
        ztytodouhukencd = pZtytodouhukencd;
        ztybotaisisyaeigyouhonbu = pZtybotaisisyaeigyouhonbu;
        ztysisyaeigyoubu = pZtysisyaeigyoubu;
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
        ztynensyuukbn = pZtynensyuukbn;
        ztyhanbaikeirokbn = pZtyhanbaikeirokbn;
        ztyoyadairitencd = pZtyoyadairitencd;
        ztytratkidrtencd = pZtytratkidrtencd;
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
        ztykyktuuka = pZtykyktuuka;
        ztyhrktuuka = pZtyhrktuuka;
        ztyhknsyukigou = pZtyhknsyukigou;
        ztysyksbyensitihsyutyhkumu = pZtysyksbyensitihsyutyhkumu;
        ztyjyudkaigomehrtkhkumu = pZtyjyudkaigomehrtkhkumu;
        ztyijitoukeizennoukbn = pZtyijitoukeizennoukbn;
        ztydai1hknkkn = pZtydai1hknkkn;
        ztyijitoukeitikshrtkykkbn = pZtyijitoukeitikshrtkykkbn;
    }

    @Transient
    @Override
    public Class<ZT_SyuHukugouSikkanDataTy> getEntityClass() {
        return ZT_SyuHukugouSikkanDataTy.class;
    }

    private String ztyijitoukeidaihyousyurui;

    public String getZtyijitoukeidaihyousyurui() {
        return ztyijitoukeidaihyousyurui;
    }

    public void setZtyijitoukeidaihyousyurui(String pZtyijitoukeidaihyousyurui) {
        ztyijitoukeidaihyousyurui = pZtyijitoukeidaihyousyurui;
    }
    private String ztykeiyakunendo;

    public String getZtykeiyakunendo() {
        return ztykeiyakunendo;
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        ztykeiyakunendo = pZtykeiyakunendo;
    }
    private String ztyhknnendo;

    public String getZtyhknnendo() {
        return ztyhknnendo;
    }

    public void setZtyhknnendo(String pZtyhknnendo) {
        ztyhknnendo = pZtyhknnendo;
    }
    private String ztyhhknseikbn;

    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }
    private String ztykykage;

    public String getZtykykage() {
        return ztykykage;
    }

    public void setZtykykage(String pZtykykage) {
        ztykykage = pZtykykage;
    }
    private String ztytoutatunenrei;

    public String getZtytoutatunenrei() {
        return ztytoutatunenrei;
    }

    public void setZtytoutatunenrei(String pZtytoutatunenrei) {
        ztytoutatunenrei = pZtytoutatunenrei;
    }
    private String ztyatukaibetu;

    public String getZtyatukaibetu() {
        return ztyatukaibetu;
    }

    public void setZtyatukaibetu(String pZtyatukaibetu) {
        ztyatukaibetu = pZtyatukaibetu;
    }
    private String ztysinsahouhou;

    public String getZtysinsahouhou() {
        return ztysinsahouhou;
    }

    public void setZtysinsahouhou(String pZtysinsahouhou) {
        ztysinsahouhou = pZtysinsahouhou;
    }
    private String ztyketteikekkakbn;

    public String getZtyketteikekkakbn() {
        return ztyketteikekkakbn;
    }

    public void setZtyketteikekkakbn(String pZtyketteikekkakbn) {
        ztyketteikekkakbn = pZtyketteikekkakbn;
    }
    private String ztysibousrank;

    public String getZtysibousrank() {
        return ztysibousrank;
    }

    public void setZtysibousrank(String pZtysibousrank) {
        ztysibousrank = pZtysibousrank;
    }
    private String ztyjissituhosyousrank;

    public String getZtyjissituhosyousrank() {
        return ztyjissituhosyousrank;
    }

    public void setZtyjissituhosyousrank(String pZtyjissituhosyousrank) {
        ztyjissituhosyousrank = pZtyjissituhosyousrank;
    }
    private String ztysirajikykkbn;

    public String getZtysirajikykkbn() {
        return ztysirajikykkbn;
    }

    public void setZtysirajikykkbn(String pZtysirajikykkbn) {
        ztysirajikykkbn = pZtysirajikykkbn;
    }
    private String ztyhrkhuhukbn;

    public String getZtyhrkhuhukbn() {
        return ztyhrkhuhukbn;
    }

    public void setZtyhrkhuhukbn(String pZtyhrkhuhukbn) {
        ztyhrkhuhukbn = pZtyhrkhuhukbn;
    }
    private String ztyhknsyurui2keta;

    public String getZtyhknsyurui2keta() {
        return ztyhknsyurui2keta;
    }

    public void setZtyhknsyurui2keta(String pZtyhknsyurui2keta) {
        ztyhknsyurui2keta = pZtyhknsyurui2keta;
    }
    private String ztydaisiincd;

    public String getZtydaisiincd() {
        return ztydaisiincd;
    }

    public void setZtydaisiincd(String pZtydaisiincd) {
        ztydaisiincd = pZtydaisiincd;
    }
    private String ztytyuusiincd;

    public String getZtytyuusiincd() {
        return ztytyuusiincd;
    }

    public void setZtytyuusiincd(String pZtytyuusiincd) {
        ztytyuusiincd = pZtytyuusiincd;
    }
    private String ztysyousiincd;

    public String getZtysyousiincd() {
        return ztysyousiincd;
    }

    public void setZtysyousiincd(String pZtysyousiincd) {
        ztysyousiincd = pZtysyousiincd;
    }
    private String ztynenreihousikikbn;

    public String getZtynenreihousikikbn() {
        return ztynenreihousikikbn;
    }

    public void setZtynenreihousikikbn(String pZtynenreihousikikbn) {
        ztynenreihousikikbn = pZtynenreihousikikbn;
    }
    private String ztysykgycd;

    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }
    private String ztytodouhukencd;

    public String getZtytodouhukencd() {
        return ztytodouhukencd;
    }

    public void setZtytodouhukencd(String pZtytodouhukencd) {
        ztytodouhukencd = pZtytodouhukencd;
    }
    private String ztybotaisisyaeigyouhonbu;

    public String getZtybotaisisyaeigyouhonbu() {
        return ztybotaisisyaeigyouhonbu;
    }

    public void setZtybotaisisyaeigyouhonbu(String pZtybotaisisyaeigyouhonbu) {
        ztybotaisisyaeigyouhonbu = pZtybotaisisyaeigyouhonbu;
    }
    private String ztysisyaeigyoubu;

    public String getZtysisyaeigyoubu() {
        return ztysisyaeigyoubu;
    }

    public void setZtysisyaeigyoubu(String pZtysisyaeigyoubu) {
        ztysisyaeigyoubu = pZtysisyaeigyoubu;
    }
    private String ztyaatukaisosikicd;

    public String getZtyaatukaisosikicd() {
        return ztyaatukaisosikicd;
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
    }
    private String ztynensyuukbn;

    public String getZtynensyuukbn() {
        return ztynensyuukbn;
    }

    public void setZtynensyuukbn(String pZtynensyuukbn) {
        ztynensyuukbn = pZtynensyuukbn;
    }
    private String ztyhanbaikeirokbn;

    public String getZtyhanbaikeirokbn() {
        return ztyhanbaikeirokbn;
    }

    public void setZtyhanbaikeirokbn(String pZtyhanbaikeirokbn) {
        ztyhanbaikeirokbn = pZtyhanbaikeirokbn;
    }
    private String ztyoyadairitencd;

    public String getZtyoyadairitencd() {
        return ztyoyadairitencd;
    }

    public void setZtyoyadairitencd(String pZtyoyadairitencd) {
        ztyoyadairitencd = pZtyoyadairitencd;
    }
    private String ztytratkidrtencd;

    public String getZtytratkidrtencd() {
        return ztytratkidrtencd;
    }

    public void setZtytratkidrtencd(String pZtytratkidrtencd) {
        ztytratkidrtencd = pZtytratkidrtencd;
    }
    private String ztybsudirtnatkikeitaikbn;

    public String getZtybsudirtnatkikeitaikbn() {
        return ztybsudirtnatkikeitaikbn;
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
    }
    private String ztykyktuuka;

    public String getZtykyktuuka() {
        return ztykyktuuka;
    }

    public void setZtykyktuuka(String pZtykyktuuka) {
        ztykyktuuka = pZtykyktuuka;
    }
    private String ztyhrktuuka;

    public String getZtyhrktuuka() {
        return ztyhrktuuka;
    }

    public void setZtyhrktuuka(String pZtyhrktuuka) {
        ztyhrktuuka = pZtyhrktuuka;
    }
    private String ztyhknsyukigou;

    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }
    private String ztysyksbyensitihsyutyhkumu;

    public String getZtysyksbyensitihsyutyhkumu() {
        return ztysyksbyensitihsyutyhkumu;
    }

    public void setZtysyksbyensitihsyutyhkumu(String pZtysyksbyensitihsyutyhkumu) {
        ztysyksbyensitihsyutyhkumu = pZtysyksbyensitihsyutyhkumu;
    }
    private String ztyjyudkaigomehrtkhkumu;

    public String getZtyjyudkaigomehrtkhkumu() {
        return ztyjyudkaigomehrtkhkumu;
    }

    public void setZtyjyudkaigomehrtkhkumu(String pZtyjyudkaigomehrtkhkumu) {
        ztyjyudkaigomehrtkhkumu = pZtyjyudkaigomehrtkhkumu;
    }
    private String ztyijitoukeizennoukbn;

    public String getZtyijitoukeizennoukbn() {
        return ztyijitoukeizennoukbn;
    }

    public void setZtyijitoukeizennoukbn(String pZtyijitoukeizennoukbn) {
        ztyijitoukeizennoukbn = pZtyijitoukeizennoukbn;
    }
    private String ztydai1hknkkn;

    public String getZtydai1hknkkn() {
        return ztydai1hknkkn;
    }

    public void setZtydai1hknkkn(String pZtydai1hknkkn) {
        ztydai1hknkkn = pZtydai1hknkkn;
    }
    private String ztyijitoukeitikshrtkykkbn;

    public String getZtyijitoukeitikshrtkykkbn() {
        return ztyijitoukeitikshrtkykkbn;
    }

    public void setZtyijitoukeitikshrtkykkbn(String pZtyijitoukeitikshrtkykkbn) {
        ztyijitoukeitikshrtkykkbn = pZtyijitoukeitikshrtkykkbn;
    }

}