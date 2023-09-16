package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.db.entity.BM_ChkNenkinSyurui;
import yuyu.def.db.mapping.GenBM_ChkNenkinSyurui;
import yuyu.def.db.meta.GenQBM_ChkNenkinSyurui;
import yuyu.def.db.meta.QBM_ChkNenkinSyurui;

/**
 * 年金種類チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkNenkinSyurui}</td><td colspan="3">年金種類チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSknenkinsyu sknenkinsyu}</td><td>新契約年金種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Sknenkinsyu}</td></tr>
 * </table>
 * @see     BM_ChkNenkinSyurui
 * @see     GenBM_ChkNenkinSyurui
 * @see     QBM_ChkNenkinSyurui
 * @see     GenQBM_ChkNenkinSyurui
 */
public class PKBM_ChkNenkinSyurui extends AbstractExDBPrimaryKey<BM_ChkNenkinSyurui, PKBM_ChkNenkinSyurui> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkNenkinSyurui() {
    }

    public PKBM_ChkNenkinSyurui(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Sknenkinsyu pSknenkinsyu
    ) {
        syouhncd = pSyouhncd;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        sknenkinsyu = pSknenkinsyu;
    }

    @Transient
    @Override
    public Class<BM_ChkNenkinSyurui> getEntityClass() {
        return BM_ChkNenkinSyurui.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private Integer syusyouhnsdnofrom;

    public Integer getSyusyouhnsdnofrom() {
        return syusyouhnsdnofrom;
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
    }
    private Integer syusyouhnsdnoto;

    public Integer getSyusyouhnsdnoto() {
        return syusyouhnsdnoto;
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        syusyouhnsdnoto = pSyusyouhnsdnoto;
    }
    private C_Sknenkinsyu sknenkinsyu;

    @org.hibernate.annotations.Type(type="UserType_C_Sknenkinsyu")
    public C_Sknenkinsyu getSknenkinsyu() {
        return sknenkinsyu;
    }

    public void setSknenkinsyu(C_Sknenkinsyu pSknenkinsyu) {
        sknenkinsyu = pSknenkinsyu;
    }

}