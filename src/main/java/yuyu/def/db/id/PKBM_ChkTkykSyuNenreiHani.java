package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.entity.BM_ChkTkykSyuNenreiHani;
import yuyu.def.db.mapping.GenBM_ChkTkykSyuNenreiHani;
import yuyu.def.db.meta.GenQBM_ChkTkykSyuNenreiHani;
import yuyu.def.db.meta.QBM_ChkTkykSyuNenreiHani;

/**
 * 特約種類年齢範囲チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkTkykSyuNenreiHani}</td><td colspan="3">特約種類年齢範囲チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getPmnjtkkbn pmnjtkkbn}</td><td>保険料免除特約区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_PmnjtkKbn}</td></tr>
 *  <tr><td>hhknfromnen</td><td>被保険者年齢自</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hhkntonen</td><td>被保険者年齢至</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_ChkTkykSyuNenreiHani
 * @see     GenBM_ChkTkykSyuNenreiHani
 * @see     QBM_ChkTkykSyuNenreiHani
 * @see     GenQBM_ChkTkykSyuNenreiHani
 */
public class PKBM_ChkTkykSyuNenreiHani extends AbstractExDBPrimaryKey<BM_ChkTkykSyuNenreiHani, PKBM_ChkTkykSyuNenreiHani> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkTkykSyuNenreiHani() {
    }

    public PKBM_ChkTkykSyuNenreiHani(C_PmnjtkKbn pPmnjtkkbn) {
        pmnjtkkbn = pPmnjtkkbn;
    }

    @Transient
    @Override
    public Class<BM_ChkTkykSyuNenreiHani> getEntityClass() {
        return BM_ChkTkykSyuNenreiHani.class;
    }

    private C_PmnjtkKbn pmnjtkkbn;

    @org.hibernate.annotations.Type(type="UserType_C_PmnjtkKbn")
    public C_PmnjtkKbn getPmnjtkkbn() {
        return pmnjtkkbn;
    }

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {
        pmnjtkkbn = pPmnjtkkbn;
    }

}