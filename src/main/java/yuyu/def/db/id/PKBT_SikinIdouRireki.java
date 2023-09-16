package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.mapping.GenBT_SikinIdouRireki;
import yuyu.def.db.meta.GenQBT_SikinIdouRireki;
import yuyu.def.db.meta.QBT_SikinIdouRireki;

/**
 * 資金移動用履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_SikinIdouRireki}</td><td colspan="3">資金移動用履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKeirisyorirenno keirisyorirenno}</td><td>経理用処理連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>targetKinouId</td><td>対象機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skno</td><td>請求番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuurirekino</td><td>請求履歴番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sakujyoflg</td><td>削除フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Delflag C_Delflag}</td></tr>
 *  <tr><td>nykshrkbn</td><td>入金支払区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NykshrKbn C_NykshrKbn}</td></tr>
 *  <tr><td>syoricd</td><td>処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>densyskbn</td><td>伝票用システム区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DensysKbn C_DensysKbn}</td></tr>
 *  <tr><td>denrenno</td><td>伝票データ連番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seg1cd</td><td>セグメント１コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syutkkbn</td><td>主契約特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno</td><td>契約商品連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrhousiteikbn</td><td>支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrhousiteiKbn C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>phendoukaisiym</td><td>Ｐ変動開始年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>phendoumaegk</td><td>Ｐ変動前金額</td><td>&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>phendougogk</td><td>Ｐ変動後金額</td><td>&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seirituymd</td><td>成立日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoumetuymd</td><td>消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>misyuupjyuutouym</td><td>未収保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>shrsyorikbn</td><td>支払処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrsyoriKbn C_ShrsyoriKbn}</td></tr>
 *  <tr><td>seikyuusyubetu</td><td>請求種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuuSyubetu C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>syoumetujiyuu</td><td>消滅事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syoumetujiyuu C_Syoumetujiyuu}</td></tr>
 *  <tr><td>jkipjytym</td><td>次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>jyutoustartym</td><td>充当開始年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>jyutouendym</td><td>充当終了年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>nykkeiro</td><td>入金経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nykkeiro C_Nykkeiro}</td></tr>
 *  <tr><td>nyknaiyoukbn</td><td>入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyknaiyouKbn C_NyknaiyouKbn}</td></tr>
 *  <tr><td>nyktrksflg</td><td>入金取消フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nyktrksflg C_Nyktrksflg}</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hokenryou</td><td>保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_SikinIdouRireki
 * @see     GenBT_SikinIdouRireki
 * @see     QBT_SikinIdouRireki
 * @see     GenQBT_SikinIdouRireki
 */
public class PKBT_SikinIdouRireki extends AbstractExDBPrimaryKey<BT_SikinIdouRireki, PKBT_SikinIdouRireki> {

    private static final long serialVersionUID = 1L;

    public PKBT_SikinIdouRireki() {
    }

    public PKBT_SikinIdouRireki(BizDate pSyoriYmd, String pKeirisyorirenno) {
        syoriYmd = pSyoriYmd;
        keirisyorirenno = pKeirisyorirenno;
    }

    @Transient
    @Override
    public Class<BT_SikinIdouRireki> getEntityClass() {
        return BT_SikinIdouRireki.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String keirisyorirenno;

    public String getKeirisyorirenno() {
        return keirisyorirenno;
    }

    public void setKeirisyorirenno(String pKeirisyorirenno) {
        keirisyorirenno = pKeirisyorirenno;
    }

}