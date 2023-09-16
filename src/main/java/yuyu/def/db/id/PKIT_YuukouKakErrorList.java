package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_YuukouKakErrorList;
import yuyu.def.db.mapping.GenIT_YuukouKakErrorList;
import yuyu.def.db.meta.GenQIT_YuukouKakErrorList;
import yuyu.def.db.meta.QIT_YuukouKakErrorList;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 有効確認エラーリストテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_YuukouKakErrorList}</td><td colspan="3">有効確認エラーリストテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriym syoriym}</td><td>処理年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>credityuukoukakym</td><td>クレジットカード有効確認年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>credityuukoukakkekka</td><td>クレジットカード有効確認結果</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Yuukoukakkekka C_Yuukoukakkekka}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_YuukouKakErrorList
 * @see     GenIT_YuukouKakErrorList
 * @see     QIT_YuukouKakErrorList
 * @see     GenQIT_YuukouKakErrorList
 */
public class PKIT_YuukouKakErrorList extends AbstractExDBPrimaryKey<IT_YuukouKakErrorList, PKIT_YuukouKakErrorList> {

    private static final long serialVersionUID = 1L;

    public PKIT_YuukouKakErrorList() {
    }

    public PKIT_YuukouKakErrorList(
        String pSyono,
        String pCreditkessaiyouno,
        BizDateYM pSyoriym
    ) {
        syono = pSyono;
        creditkessaiyouno = pCreditkessaiyouno;
        syoriym = pSyoriym;
    }

    @Transient
    @Override
    public Class<IT_YuukouKakErrorList> getEntityClass() {
        return IT_YuukouKakErrorList.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String creditkessaiyouno;

    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }
    private BizDateYM syoriym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getSyoriym() {
        return syoriym;
    }

    public void setSyoriym(BizDateYM pSyoriym) {
        syoriym = pSyoriym;
    }

}