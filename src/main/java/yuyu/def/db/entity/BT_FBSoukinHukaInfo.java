package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_FBSoukinHukaInfo;

/**
 * ＦＢ送金付加情報データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_FBSoukinHukaInfo} の JavaDoc を参照してください。<br />
 * @see     GenBT_FBSoukinHukaInfo<br />
 * @see     PKBT_FBSoukinHukaInfo<br />
 * @see     QBT_FBSoukinHukaInfo<br />
 * @see     GenQBT_FBSoukinHukaInfo<br />
 */
@Entity
public class BT_FBSoukinHukaInfo extends GenBT_FBSoukinHukaInfo {

    private static final long serialVersionUID = 1L;

    public BT_FBSoukinHukaInfo() {
    }

    public BT_FBSoukinHukaInfo(String pFbsoukindatasikibetukey) {
        super(pFbsoukindatasikibetukey);
    }



    private BT_FBSoukinData bT_FBSoukinData ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_FBSoukinHukaInfo.FBSOUKINDATASIKIBETUKEY  , referencedColumnName=BT_FBSoukinData.FBSOUKINDATASIKIBETUKEY, insertable=false, updatable=false)
    })
    public BT_FBSoukinData getFBSoukinData() {
        return bT_FBSoukinData;
    }

    public void setFBSoukinData(BT_FBSoukinData pBT_FBSoukinData) {
        this.bT_FBSoukinData = pBT_FBSoukinData;
    }

}

