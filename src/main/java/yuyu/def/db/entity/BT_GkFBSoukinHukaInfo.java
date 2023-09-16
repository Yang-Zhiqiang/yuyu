package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_GkFBSoukinHukaInfo;

/**
 * 外貨ＦＢ送金付加情報データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_GkFBSoukinHukaInfo} の JavaDoc を参照してください。<br />
 * @see     GenBT_GkFBSoukinHukaInfo<br />
 * @see     PKBT_GkFBSoukinHukaInfo<br />
 * @see     QBT_GkFBSoukinHukaInfo<br />
 * @see     GenQBT_GkFBSoukinHukaInfo<br />
 */
@Entity
public class BT_GkFBSoukinHukaInfo extends GenBT_GkFBSoukinHukaInfo {

    private static final long serialVersionUID = 1L;

    public BT_GkFBSoukinHukaInfo() {
    }

    public BT_GkFBSoukinHukaInfo(String pFbsoukindatasikibetukey) {
        super(pFbsoukindatasikibetukey);
    }



    private BT_GkFBSoukinData bT_GkFBSoukinData ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_GkFBSoukinHukaInfo.FBSOUKINDATASIKIBETUKEY  , referencedColumnName=BT_GkFBSoukinData.FBSOUKINDATASIKIBETUKEY, insertable=false, updatable=false)
    })
    public BT_GkFBSoukinData getGkFBSoukinData() {
        return bT_GkFBSoukinData;
    }

    public void setGkFBSoukinData(BT_GkFBSoukinData pBT_GkFBSoukinData) {
        this.bT_GkFBSoukinData = pBT_GkFBSoukinData;
    }

}

