CREATE TABLE HM_SkDairitenKobetuJyouhou (
     oyadrtencd                                         VARCHAR     (7)                                                       NOT NULL  ,  /* 親代理店コード */
     utdskknnm1kj                                       VARCHAR     (15)                                                                ,  /* 打出機関名１（漢字） */
     utdskknnm2kj                                       VARCHAR     (15)                                                                ,  /* 打出機関名２（漢字） */
     nykntratkikbn                                      VARCHAR     (1)                                                                 ,  /* 入金取扱区分 */
     trksskssouhukbn                                    VARCHAR     (1)                                                                 ,  /* 取消請求書送付区分 */
     tkhjnkinyuucd                                      VARCHAR     (4)                                                                 ,  /* 特定関係法人金融機関コード */
     drtentrkno                                         VARCHAR     (13)                                                                ,  /* 代理店登録番号 */
     cifcdcheckyouhi                                    VARCHAR     (1)                                                                 ,  /* ＣＩＦコードチェック要否 */
     cifcdsiteiketasuu                                  VARCHAR     (2)                                                                 ,  /* ＣＩＦコード指定桁数 */
     cifcdmaezeroumeyouhi                               VARCHAR     (1)                                                                 ,  /* ＣＩＦコード前ゼロ埋め要否 */
     kosymd                                             VARCHAR     (8)                                                                 ,  /* 更新日 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HM_SkDairitenKobetuJyouhou ADD CONSTRAINT PK_SkDairitenKobetuJyouhou PRIMARY KEY (
     oyadrtencd                                                 /* 親代理店コード */
) ;
