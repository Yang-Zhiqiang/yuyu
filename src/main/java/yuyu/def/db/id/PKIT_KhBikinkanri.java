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
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.mapping.GenIT_KhBikinkanri;
import yuyu.def.db.meta.GenQIT_KhBikinkanri;
import yuyu.def.db.meta.QIT_KhBikinkanri;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全備金管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhBikinkanri}</td><td colspan="3">契約保全備金管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKessankijyunymd kessankijyunymd}</td><td>決算基準日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBkncdkbn bkncdkbn}</td><td>備金コード区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_BkncdKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBknkktymd bknkktymd}</td><td>備金確定日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>bknrigikbn</td><td>備金例外区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BknrigiKbn C_BknrigiKbn}</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>calckijyunymd</td><td>計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sisyacd</td><td>支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kbnkeirisegcd</td><td>区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bknsyutkkbn</td><td>備金主契約特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BknsyutkKbn C_BknsyutkKbn}</td></tr>
 *  <tr><td>bkngk</td><td>備金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons</td><td>基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gngkkiykumukbn</td><td>減額特約解約有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>shrumu</td><td>支払有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sinsaumukbn</td><td>診査有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>bknjkukbn</td><td>備金時効区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BknJkuKbn C_BknJkuKbn}</td></tr>
 *  <tr><td>shrsyoriymd</td><td>支払処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tyakkinymd</td><td>着金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrgk</td><td>支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrkwsratekjnymd</td><td>支払時為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrkwsrate</td><td>支払時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gaikashrkwsratekjnymd</td><td>外貨支払時為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gaikashrkwsrate</td><td>外貨支払時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenkazennouseisankgk</td><td>円貨前納精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gaikazennouseisankgk</td><td>外貨前納精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennouseisankgk</td><td>前納精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkamikeikap</td><td>円貨未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gaikamikeikap</td><td>外貨未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mikeikap</td><td>未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_KhBikinkanri
 * @see     GenIT_KhBikinkanri
 * @see     QIT_KhBikinkanri
 * @see     GenQIT_KhBikinkanri
 */
public class PKIT_KhBikinkanri extends AbstractExDBPrimaryKey<IT_KhBikinkanri, PKIT_KhBikinkanri> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhBikinkanri() {
    }

    public PKIT_KhBikinkanri(
        String pSyono,
        BizDate pKessankijyunymd,
        C_BkncdKbn pBkncdkbn,
        BizDate pBknkktymd,
        Integer pRenno
    ) {
        syono = pSyono;
        kessankijyunymd = pKessankijyunymd;
        bkncdkbn = pBkncdkbn;
        bknkktymd = pBknkktymd;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_KhBikinkanri> getEntityClass() {
        return IT_KhBikinkanri.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate kessankijyunymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKessankijyunymd() {
        return kessankijyunymd;
    }

    public void setKessankijyunymd(BizDate pKessankijyunymd) {
        kessankijyunymd = pKessankijyunymd;
    }
    private C_BkncdKbn bkncdkbn;

    @org.hibernate.annotations.Type(type="UserType_C_BkncdKbn")
    public C_BkncdKbn getBkncdkbn() {
        return bkncdkbn;
    }

    public void setBkncdkbn(C_BkncdKbn pBkncdkbn) {
        bkncdkbn = pBkncdkbn;
    }
    private BizDate bknkktymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getBknkktymd() {
        return bknkktymd;
    }

    public void setBknkktymd(BizDate pBknkktymd) {
        bknkktymd = pBknkktymd;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}