package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenBT_GkFBSoukinData;

import com.google.common.collect.Lists;

/**
 * 外貨ＦＢ送金データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_GkFBSoukinData} の JavaDoc を参照してください。<br />
 * @see     GenBT_GkFBSoukinData<br />
 * @see     PKBT_GkFBSoukinData<br />
 * @see     QBT_GkFBSoukinData<br />
 * @see     GenQBT_GkFBSoukinData<br />
 */
@Entity
public class BT_GkFBSoukinData extends GenBT_GkFBSoukinData {

    private static final long serialVersionUID = 1L;

    public BT_GkFBSoukinData() {
    }

    public BT_GkFBSoukinData(String pFbsoukindatasikibetukey) {
        super(pFbsoukindatasikibetukey);
    }



    private List<BT_GkFBSoukinHukaInfo> bT_GkFBSoukinHukaInfos = Lists.newLinkedList();
    public BT_GkFBSoukinHukaInfo createGkFBSoukinHukaInfo() {
        BT_GkFBSoukinHukaInfo gkFBSoukinHukaInfo =  new BT_GkFBSoukinHukaInfo();
        gkFBSoukinHukaInfo.setGkFBSoukinData(this);
        gkFBSoukinHukaInfo.setFbsoukindatasikibetukey(this.getFbsoukindatasikibetukey());
        setGkFBSoukinHukaInfo(gkFBSoukinHukaInfo);
        return gkFBSoukinHukaInfo;
    }
    @Transient
    public  BT_GkFBSoukinHukaInfo getGkFBSoukinHukaInfo() {
        if(getGkFBSoukinHukaInfos().size() == 0) {
            return null;
        }
        return getGkFBSoukinHukaInfos().get(0);
    }
    @Transient
    public void setGkFBSoukinHukaInfo(BT_GkFBSoukinHukaInfo pBT_GkFBSoukinHukaInfo) {
        if(this.getGkFBSoukinHukaInfos().size() >0){
            this.getGkFBSoukinHukaInfos().set(0, pBT_GkFBSoukinHukaInfo) ;
        }else{
            this.getGkFBSoukinHukaInfos().add(pBT_GkFBSoukinHukaInfo) ;
        }
    }
    public void setGkFBSoukinHukaInfos(List<BT_GkFBSoukinHukaInfo> pBT_GkFBSoukinHukaInfos) {
        this.bT_GkFBSoukinHukaInfos = pBT_GkFBSoukinHukaInfos;
    }
    @OneToMany (
        mappedBy = "gkFBSoukinData",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_GkFBSoukinHukaInfo.FBSOUKINDATASIKIBETUKEY+" ASC ")
    public  List<BT_GkFBSoukinHukaInfo> getGkFBSoukinHukaInfos() {
        return bT_GkFBSoukinHukaInfos;
    }

    private BM_FBSoukinListKanri bM_FBSoukinListKanri ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_GkFBSoukinData.SYORICD  , referencedColumnName=BM_FBSoukinListKanri.SYORICD, insertable=false, updatable=false),
        @JoinColumn(name=BT_GkFBSoukinData.SYORISOSIKICD  , referencedColumnName=BM_FBSoukinListKanri.SYORISOSIKICD, insertable=false, updatable=false)
    })
    public  BM_FBSoukinListKanri getFBSoukinListKanri() {
        return bM_FBSoukinListKanri;
    }

    public void setFBSoukinListKanri(BM_FBSoukinListKanri pBM_FBSoukinListKanri) {
        this.bM_FBSoukinListKanri = pBM_FBSoukinListKanri;
    }

}

