package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SntkInfoTourokuTy;
import yuyu.def.db.mapping.GenZT_SntkInfoTourokuTy;
import yuyu.def.db.meta.GenQZT_SntkInfoTourokuTy;
import yuyu.def.db.meta.QZT_SntkInfoTourokuTy;

/**
 * 選択情報登録テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SntkInfoTourokuTy}</td><td colspan="3">選択情報登録テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysntkinfono ztysntkinfono}</td><td>（中継用）選択情報番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyrenno ztyrenno}</td><td>（中継用）連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysntkinfotourokusyskbn ztysntkinfotourokusyskbn}</td><td>（中継用）選択情報登録システム区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoriymd</td><td>（中継用）処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhuho2kyknokbn</td><td>（中継用）普保Ⅱ契約番号区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhuho2kykno</td><td>（中継用）普保Ⅱ契約番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouhncd</td><td>（中継用）商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfofsegkbn</td><td>（中継用）選択情報ＦＳＥＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfofkojinkbn</td><td>（中継用）選択情報Ｆ個人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytaisyounm</td><td>（中継用）対象者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtaisyounm</td><td>（中継用）漢字対象者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytaisyouseiymd</td><td>（中継用）対象者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytaisyouseibetu</td><td>（中継用）対象者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketnaiyouarihyj</td><td>（中継用）諾否決定内容有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykktnaiyouarihyj</td><td>（中継用）告知内容有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykijinaiyouarihyj</td><td>（中継用）記事内容有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrarihyj</td><td>（中継用）ＭＲ有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykoudosyougaiarihyj</td><td>（中継用）高度障害有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytorikaijoarihyj</td><td>（中継用）取消解除有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskhuseirituhyouji</td><td>（中継用）新契約不成立表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfotourokuyobi01</td><td>（中継用）選択情報登録予備０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydeckbn</td><td>（中継用）ＤＥＣ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketymd</td><td>（中継用）決定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketkekkacd</td><td>（中継用）決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketriyuucd1</td><td>（中継用）決定理由コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketriyuucd2</td><td>（中継用）決定理由コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketriyuucd3</td><td>（中継用）決定理由コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketriyuucd4</td><td>（中継用）決定理由コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketsyacd</td><td>（中継用）決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfotourokuyobi02</td><td>（中継用）選択情報登録予備０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfosintyou</td><td>（中継用）選択情報身長</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfotaijyuu</td><td>（中継用）選択情報体重</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykokutiymd</td><td>（中継用）告知年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfotourokuyobi03</td><td>（中継用）選択情報登録予備０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoubyoucd1</td><td>（中継用）傷病コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykantiym1</td><td>（中継用）完治年月１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoubyoucd2</td><td>（中継用）傷病コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykantiym2</td><td>（中継用）完治年月２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfotourokuyobi04</td><td>（中継用）選択情報登録予備０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrriyuucdkbn</td><td>（中継用）ＭＲ理由コード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfotourokuyobi05</td><td>（中継用）選択情報登録予備０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfokyktorikesikbn</td><td>（中継用）選択情報用契約取消処理区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfotourokuyobi06</td><td>（中継用）選択情報登録予備０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykdsssiharaijyoutaikbn</td><td>（中継用）高度障害Ｓ支払状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykdsssiharaiymd</td><td>（中継用）高度障害Ｓ支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykdsymd</td><td>（中継用）高度障害年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykdssiharaisosikicd</td><td>（中継用）高度障害支払組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntkinfotourokuyobi07</td><td>（中継用）選択情報登録予備０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SntkInfoTourokuTy
 * @see     GenZT_SntkInfoTourokuTy
 * @see     QZT_SntkInfoTourokuTy
 * @see     GenQZT_SntkInfoTourokuTy
 */
public class PKZT_SntkInfoTourokuTy extends AbstractExDBPrimaryKey<ZT_SntkInfoTourokuTy, PKZT_SntkInfoTourokuTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SntkInfoTourokuTy() {
    }

    public PKZT_SntkInfoTourokuTy(
        String pZtysntkinfono,
        String pZtyrenno,
        String pZtysntkinfotourokusyskbn
    ) {
        ztysntkinfono = pZtysntkinfono;
        ztyrenno = pZtyrenno;
        ztysntkinfotourokusyskbn = pZtysntkinfotourokusyskbn;
    }

    @Transient
    @Override
    public Class<ZT_SntkInfoTourokuTy> getEntityClass() {
        return ZT_SntkInfoTourokuTy.class;
    }

    private String ztysntkinfono;

    public String getZtysntkinfono() {
        return ztysntkinfono;
    }

    public void setZtysntkinfono(String pZtysntkinfono) {
        ztysntkinfono = pZtysntkinfono;
    }
    private String ztyrenno;

    public String getZtyrenno() {
        return ztyrenno;
    }

    public void setZtyrenno(String pZtyrenno) {
        ztyrenno = pZtyrenno;
    }
    private String ztysntkinfotourokusyskbn;

    public String getZtysntkinfotourokusyskbn() {
        return ztysntkinfotourokusyskbn;
    }

    public void setZtysntkinfotourokusyskbn(String pZtysntkinfotourokusyskbn) {
        ztysntkinfotourokusyskbn = pZtysntkinfotourokusyskbn;
    }

}