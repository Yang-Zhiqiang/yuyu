package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SyuSibouToukeiRn;
import yuyu.def.db.mapping.GenZT_SyuSibouToukeiRn;
import yuyu.def.db.meta.GenQZT_SyuSibouToukeiRn;
import yuyu.def.db.meta.QZT_SyuSibouToukeiRn;

/**
 * 主契約死亡統計データテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyuSibouToukeiRn}</td><td colspan="3">主契約死亡統計データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyurui2keta</td><td>（連携用）保険種類（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatukaibetu</td><td>（連携用）扱別</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen3</td><td>（連携用）被保険者年令（３文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoutatunenrei</td><td>（連携用）到達年齢</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykym</td><td>（連携用）契約年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsymtym</td><td>（連携用）消滅年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoriymd</td><td>（連携用）処理年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyktuuka</td><td>（連携用）契約通貨</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnimustiyusbus</td><td>（連携用）医務査定用死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsykgycd</td><td>（連携用）職業コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkhuhukbn</td><td>（連携用）払込方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsirajikykkbn</td><td>（連携用）白地契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatukaisosikicd</td><td>（連携用）Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatukaikojincd</td><td>（連携用）Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsinsahouhou</td><td>（連携用）診査方法</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsinsasyacd</td><td>（連携用）診査者コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnketteikekkakbn</td><td>（連携用）決定結果区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhikettisyacd</td><td>（連携用）諾否決定者コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoubyoutyuubunrui</td><td>（連携用）傷病中分類１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoubyoucd1x5</td><td>（連携用）傷病コード１（５文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoubyoucd2x5</td><td>（連携用）傷病コード２（５文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndaisiincd</td><td>（連携用）大死因コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyuusiincd</td><td>（連携用）中死因コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyousiincd</td><td>（連携用）小死因コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsoukisibouhyj</td><td>（連携用）早期死亡表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeikakikankbn</td><td>（連携用）経過期間区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkoudosyougaiarihyj</td><td>（連携用）高度障害有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaijyokbn</td><td>（連携用）解除区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnensyuukbn</td><td>（連携用）年収区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhanbaikeirokbn</td><td>（連携用）販売経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnoyadairitencd</td><td>（連携用）親代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbyoumeicd</td><td>（連携用）病名コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyksbyensitihsyutyhkumu</td><td>（連携用）初期死亡時円換算最低保証特約付加有無</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyudkaigomehrtkhkumu</td><td>（連携用）重度介護前払特約付加有無</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnijitoukeizennoukbn</td><td>（連携用）医事統計用前納区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai1hknkkn</td><td>（連携用）第１保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnijitoukeitikshrtkykkbn</td><td>（連携用）医事統計用定期支払特約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikisiharaikinmanen</td><td>（連携用）定期支払金（万円）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyobiv78</td><td>（連携用）予備項目Ｖ７８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyuSibouToukeiRn
 * @see     GenZT_SyuSibouToukeiRn
 * @see     QZT_SyuSibouToukeiRn
 * @see     GenQZT_SyuSibouToukeiRn
 */
public class PKZT_SyuSibouToukeiRn extends AbstractExDBPrimaryKey<ZT_SyuSibouToukeiRn, PKZT_SyuSibouToukeiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SyuSibouToukeiRn() {
    }

    public PKZT_SyuSibouToukeiRn(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_SyuSibouToukeiRn> getEntityClass() {
        return ZT_SyuSibouToukeiRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}