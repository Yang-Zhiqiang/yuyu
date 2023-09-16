package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_ChkNenkinSaiteiS;


/**
 * 年金支払特約最低Ｓチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkNenkinSaiteiS} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkNenkinSaiteiS<br />
 * @see     PKBM_ChkNenkinSaiteiS<br />
 * @see     QBM_ChkNenkinSaiteiS<br />
 * @see     GenQBM_ChkNenkinSaiteiS<br />
 */
@Entity
public class BM_ChkNenkinSaiteiS extends GenBM_ChkNenkinSaiteiS {

    private static final long serialVersionUID = 1L;

    public BM_ChkNenkinSaiteiS() {
    }

    public BM_ChkNenkinSaiteiS(Integer pNenkinkkn,String pNenkinsyu) {
        super(pNenkinkkn,pNenkinsyu);
    }



}

