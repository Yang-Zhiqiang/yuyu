CREATE TABLE BT_HknBosyuRiyouInfo_Z (
     drtencd                                            VARCHAR     (7)                                                       NOT NULL  ,  /* 代理店コード */
     gwriyoukbn                                         VARCHAR     (1)                                                                 ,  /* ＧＷ利用区分 */
     gwkykrendouumukbn                                  VARCHAR     (1)                                                                 ,  /* ＧＷ契約データ連動有無区分 */
     gwtsryrendouumukbn                                 VARCHAR     (1)                                                                 ,  /* ＧＷ手数料データ連動有無区分 */
     gwmisyuurendouumukbn                               VARCHAR     (1)                                                                 ,  /* ＧＷ未収データ連動有無区分 */
     issriyoukbn                                        VARCHAR     (1)                                                                 ,  /* ＩＳＳ利用区分 */
     gwtkyyoteiymd                                      VARCHAR     (8)                                                                 ,  /* ＧＷ適用予定日 */
     gwsousinsikibetusi                                 VARCHAR     (21)                                                                ,  /* ＧＷ送信識別子 */
     gwtsrykbn                                          VARCHAR     (1)                                                                 ,  /* ＧＷ手数料区分 */
     internetstzkriyoukbn                               VARCHAR     (1)                                                                 ,  /* インターネット接続利用区分 */
     hokenbossysriyoukbn                                VARCHAR     (1)                                                                 ,  /* 保険募集システム利用区分 */
     lphteikeitiginkbn                                  VARCHAR     (1)                                                                 ,  /* ＬＰＨ提携地銀区分 */
     tmbosyuukbn                                        VARCHAR     (1)                                                                 ,  /* 対面募集区分 */
     hitmbosyuukbn                                      VARCHAR     (1)                                                                 ,  /* 非対面募集区分 */
     kansyoutuutisakuseiyhkbn                           VARCHAR     (1)                                                                 ,  /* 代理店勧奨通知作成要否区分 */
     fatcakakuninyhkbn                                  VARCHAR     (1)                                                                 ,  /* FATCA確認要否区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_HknBosyuRiyouInfo_Z ADD CONSTRAINT PK_HknBosyuRiyouInfo PRIMARY KEY (
     drtencd                                                    /* 代理店コード */
) ;
