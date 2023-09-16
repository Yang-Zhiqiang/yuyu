package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NkGensiKtyTy;
import yuyu.def.db.mapping.GenZT_NkGensiKtyTy;
import yuyu.def.db.meta.GenQZT_NkGensiKtyTy;
import yuyu.def.db.meta.QZT_NkGensiKtyTy;

/**
 * 年金原資Ｆ期中報告用テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkGensiKtyTy}</td><td colspan="3">年金原資Ｆ期中報告用テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysystemcd</td><td>（中継用）システムコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyulfkbn</td><td>（中継用）ＵＬＦ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrecordkihonkbn</td><td>（中継用）レコード基本区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv6</td><td>（中継用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyousyono</td><td>（中継用）年金証書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrecordkbn</td><td>（中継用）レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyidouymd</td><td>（中継用）異動日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouin</td><td>（中継用）消因</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikbn</td><td>（中継用）年金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkbn</td><td>（中継用）年金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinsyu</td><td>（中継用）年金種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkaisikbn</td><td>（中継用）年金開始区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuymd</td><td>（中継用）契約日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokainenkinsiharaiymd</td><td>（中継用）初回年金支払日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynknshry</td><td>（中継用）年金支払期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinhosyoukikan</td><td>（中継用）年金保証期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhnnkgk</td><td>（中継用）基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysaisyuukousinymd</td><td>（中継用）最終更新日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaisyuukousinsyoricd</td><td>（中継用）最終更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkihonctr</td><td>（中継用）年金基本ＣＴＲ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztycurrentday</td><td>（中継用）現在日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycurrenttime</td><td>（中継用）現在時刻</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoricd</td><td>（中継用）処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykessanjibikinkbn</td><td>（中継用）決算時備金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyoumetucd</td><td>（中継用）年金消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyoumetuymd</td><td>（中継用）年金消滅日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouryokuhasseiymd</td><td>（中継用）効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykingakuzoukanaiyoukbn</td><td>（中継用）金額増加内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymotokeiyakusyouhinkbn</td><td>（中継用）元契約商品区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkigousedaikbn</td><td>（中継用）年金記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrrthendounkyoteirrt</td><td>（中継用）利率変動年金予定利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztyrrthendounksitihsyurrt</td><td>（中継用）利率変動年金最低保証利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztyhenkoumaekihonnenkingaku</td><td>（中継用）変更前基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynenkingensino</td><td>（中継用）年金原資番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkingensinaiyoukbn</td><td>（中継用）年金原資内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkkikingk</td><td>（中継用）年金基金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygensinaiyoukihonnkgk</td><td>（中継用）原資内容基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynewmoneygaku</td><td>（中継用）ニューマネー額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynenkingensihasseiymd</td><td>（中継用）年金原資発生日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydkeisanyounenkingaku</td><td>（中継用）Ｄ計算用年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykgynkyouzeiseitkkaksjgns</td><td>（中継用）企業年金用税制適格開始時原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_NkGensiKtyTy
 * @see     GenZT_NkGensiKtyTy
 * @see     QZT_NkGensiKtyTy
 * @see     GenQZT_NkGensiKtyTy
 */
public class PKZT_NkGensiKtyTy extends AbstractExDBPrimaryKey<ZT_NkGensiKtyTy, PKZT_NkGensiKtyTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_NkGensiKtyTy() {
    }

    public PKZT_NkGensiKtyTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_NkGensiKtyTy> getEntityClass() {
        return ZT_NkGensiKtyTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}