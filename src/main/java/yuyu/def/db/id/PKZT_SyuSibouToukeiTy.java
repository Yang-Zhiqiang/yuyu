package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SyuSibouToukeiTy;
import yuyu.def.db.mapping.GenZT_SyuSibouToukeiTy;
import yuyu.def.db.meta.GenQZT_SyuSibouToukeiTy;
import yuyu.def.db.meta.QZT_SyuSibouToukeiTy;

/**
 * 主契約死亡統計データテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyuSibouToukeiTy}</td><td colspan="3">主契約死亡統計データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyurui2keta</td><td>（中継用）保険種類（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatukaibetu</td><td>（中継用）扱別</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen3</td><td>（中継用）被保険者年令（３文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoutatunenrei</td><td>（中継用）到達年齢</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykym</td><td>（中継用）契約年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysymtym</td><td>（中継用）消滅年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoriymd</td><td>（中継用）処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyktuuka</td><td>（中継用）契約通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyimustiyusbus</td><td>（中継用）医務査定用死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysykgycd</td><td>（中継用）職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkhuhukbn</td><td>（中継用）払込方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysirajikykkbn</td><td>（中継用）白地契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaisosikicd</td><td>（中継用）Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaikojincd</td><td>（中継用）Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinsahouhou</td><td>（中継用）診査方法</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinsasyacd</td><td>（中継用）診査者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketteikekkakbn</td><td>（中継用）決定結果区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhikettisyacd</td><td>（中継用）諾否決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoubyoutyuubunrui</td><td>（中継用）傷病中分類１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoubyoucd1x5</td><td>（中継用）傷病コード１（５文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoubyoucd2x5</td><td>（中継用）傷病コード２（５文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydaisiincd</td><td>（中継用）大死因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyuusiincd</td><td>（中継用）中死因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyousiincd</td><td>（中継用）小死因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysoukisibouhyj</td><td>（中継用）早期死亡表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikakikankbn</td><td>（中継用）経過期間区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykoudosyougaiarihyj</td><td>（中継用）高度障害有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaijyokbn</td><td>（中継用）解除区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynensyuukbn</td><td>（中継用）年収区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhanbaikeirokbn</td><td>（中継用）販売経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyoyadairitencd</td><td>（中継用）親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybyoumeicd</td><td>（中継用）病名コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyksbyensitihsyutyhkumu</td><td>（中継用）初期死亡時円換算最低保証特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyudkaigomehrtkhkumu</td><td>（中継用）重度介護前払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyijitoukeizennoukbn</td><td>（中継用）医事統計用前納区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1hknkkn</td><td>（中継用）第１保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyijitoukeitikshrtkykkbn</td><td>（中継用）医事統計用定期支払特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikisiharaikinmanen</td><td>（中継用）定期支払金（万円）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobiv78</td><td>（中継用）予備項目Ｖ７８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyuSibouToukeiTy
 * @see     GenZT_SyuSibouToukeiTy
 * @see     QZT_SyuSibouToukeiTy
 * @see     GenQZT_SyuSibouToukeiTy
 */
public class PKZT_SyuSibouToukeiTy extends AbstractExDBPrimaryKey<ZT_SyuSibouToukeiTy, PKZT_SyuSibouToukeiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SyuSibouToukeiTy() {
    }

    public PKZT_SyuSibouToukeiTy(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_SyuSibouToukeiTy> getEntityClass() {
        return ZT_SyuSibouToukeiTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}