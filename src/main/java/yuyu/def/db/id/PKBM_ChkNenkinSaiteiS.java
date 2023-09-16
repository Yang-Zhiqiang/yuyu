package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_ChkNenkinSaiteiS;
import yuyu.def.db.mapping.GenBM_ChkNenkinSaiteiS;
import yuyu.def.db.meta.GenQBM_ChkNenkinSaiteiS;
import yuyu.def.db.meta.QBM_ChkNenkinSaiteiS;

/**
 * 年金支払特約最低Ｓチェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkNenkinSaiteiS}</td><td colspan="3">年金支払特約最低Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getNenkinkkn nenkinkkn}</td><td>年金期間</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNenkinsyu nenkinsyu}</td><td>年金種類</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saiteis</td><td>最低Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkNenkinSaiteiS
 * @see     GenBM_ChkNenkinSaiteiS
 * @see     QBM_ChkNenkinSaiteiS
 * @see     GenQBM_ChkNenkinSaiteiS
 */
public class PKBM_ChkNenkinSaiteiS extends AbstractExDBPrimaryKey<BM_ChkNenkinSaiteiS, PKBM_ChkNenkinSaiteiS> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkNenkinSaiteiS() {
    }

    public PKBM_ChkNenkinSaiteiS(Integer pNenkinkkn, String pNenkinsyu) {
        nenkinkkn = pNenkinkkn;
        nenkinsyu = pNenkinsyu;
    }

    @Transient
    @Override
    public Class<BM_ChkNenkinSaiteiS> getEntityClass() {
        return BM_ChkNenkinSaiteiS.class;
    }

    private Integer nenkinkkn;

    public Integer getNenkinkkn() {
        return nenkinkkn;
    }

    public void setNenkinkkn(Integer pNenkinkkn) {
        nenkinkkn = pNenkinkkn;
    }
    private String nenkinsyu;

    public String getNenkinsyu() {
        return nenkinsyu;
    }

    public void setNenkinsyu(String pNenkinsyu) {
        nenkinsyu = pNenkinsyu;
    }

}