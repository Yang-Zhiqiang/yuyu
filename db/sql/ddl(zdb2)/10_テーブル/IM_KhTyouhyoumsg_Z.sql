CREATE TABLE IM_KhTyouhyoumsg_Z (
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     meigihnkjiyuu                                      VARCHAR     (1)                                                       NOT NULL  ,  /* 名義変更事由 */
     kyksbumu                                           VARCHAR     (1)                                                       NOT NULL  ,  /* 契約者死亡有無 */
     shrumu                                             VARCHAR     (1)                                                       NOT NULL  ,  /* 支払有無区分 */
     tuityouumu                                         VARCHAR     (1)                                                       NOT NULL  ,  /* 追徴有無区分 */
     tyouhyoutitle                                      VARCHAR     (62)                                                                ,  /* 帳票タイトル */
     rsouhuannaimsg1                                    VARCHAR     (102)                                                               ,  /* （帳票用）送付案内メッセージ１ */
     rsouhuannaimsg2                                    VARCHAR     (102)                                                               ,  /* （帳票用）送付案内メッセージ２ */
     rsouhuannaimsg3                                    VARCHAR     (102)                                                               ,  /* （帳票用）送付案内メッセージ３ */
     rsouhuannaimsg4                                    VARCHAR     (102)                                                               ,  /* （帳票用）送付案内メッセージ４ */
     rsouhuannaimsg5                                    VARCHAR     (102)                                                               ,  /* （帳票用）送付案内メッセージ５ */
     rsouhuannaimsg6                                    VARCHAR     (102)                                                               ,  /* （帳票用）送付案内メッセージ６ */
     rsouhuannaimsg7                                    VARCHAR     (102)                                                               ,  /* （帳票用）送付案内メッセージ７ */
     rsouhuannaimsg8                                    VARCHAR     (102)                                                               ,  /* （帳票用）送付案内メッセージ８ */
     rsouhuannaimsg9                                    VARCHAR     (102)                                                               ,  /* （帳票用）送付案内メッセージ９ */
     rsouhuannaimsg10                                   VARCHAR     (102)                                                               ,  /* （帳票用）送付案内メッセージ１０ */
     rannainaiyoumsg1                                   VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ１ */
     rannainaiyoumsg2                                   VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ２ */
     rannainaiyoumsg3                                   VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ３ */
     rannainaiyoumsg4                                   VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ４ */
     rannainaiyoumsg5                                   VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ５ */
     rannainaiyoumsg6                                   VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ６ */
     rannainaiyoumsg7                                   VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ７ */
     rannainaiyoumsg8                                   VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ８ */
     rannainaiyoumsg9                                   VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ９ */
     rannainaiyoumsg10                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ１０ */
     rannainaiyoumsg11                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ１１ */
     rannainaiyoumsg12                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ１２ */
     rannainaiyoumsg13                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ１３ */
     rannainaiyoumsg14                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ１４ */
     rannainaiyoumsg15                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ１５ */
     rannainaiyoumsg16                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ１６ */
     rannainaiyoumsg17                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ１７ */
     rannainaiyoumsg18                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ１８ */
     rannainaiyoumsg19                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ１９ */
     rannainaiyoumsg20                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ２０ */
     rannainaiyoumsg21                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ２１ */
     rannainaiyoumsg22                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ２２ */
     rannainaiyoumsg23                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ２３ */
     rannainaiyoumsg24                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ２４ */
     rannainaiyoumsg25                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ２５ */
     rannainaiyoumsg26                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ２６ */
     rannainaiyoumsg27                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ２７ */
     rannainaiyoumsg28                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ２８ */
     rannainaiyoumsg29                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ２９ */
     rannainaiyoumsg30                                  VARCHAR     (102)                                                               ,  /* （帳票用）案内内容メッセージ３０ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IM_KhTyouhyoumsg_Z ADD CONSTRAINT PK_KhTyouhyoumsg PRIMARY KEY (
     syoruiCd                                                 , /* 書類コード */
     meigihnkjiyuu                                            , /* 名義変更事由 */
     kyksbumu                                                 , /* 契約者死亡有無 */
     shrumu                                                   , /* 支払有無区分 */
     tuityouumu                                                 /* 追徴有無区分 */
) ;
