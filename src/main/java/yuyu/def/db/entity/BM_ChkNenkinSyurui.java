package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.db.mapping.GenBM_ChkNenkinSyurui;


/**
 * 年金種類チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkNenkinSyurui} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkNenkinSyurui<br />
 * @see     PKBM_ChkNenkinSyurui<br />
 * @see     QBM_ChkNenkinSyurui<br />
 * @see     GenQBM_ChkNenkinSyurui<br />
 */
@Entity
public class BM_ChkNenkinSyurui extends GenBM_ChkNenkinSyurui {

    private static final long serialVersionUID = 1L;

    public BM_ChkNenkinSyurui() {
    }

    public BM_ChkNenkinSyurui(String pSyouhncd,Integer pSyusyouhnsdnofrom,Integer pSyusyouhnsdnoto,C_Sknenkinsyu pSknenkinsyu) {
        super(pSyouhncd,pSyusyouhnsdnofrom,pSyusyouhnsdnoto,pSknenkinsyu);
    }



}

