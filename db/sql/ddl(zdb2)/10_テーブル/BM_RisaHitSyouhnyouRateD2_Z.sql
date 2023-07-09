CREATE TABLE BM_RisaHitSyouhnyouRateD2_Z (
     palhokensyuruikigou                                CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ予定利率 */
     palpmencode                                        CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                 CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ払込回数 */
     palhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                  CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                      CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険期間 */
     palpharaikomikikan                                 CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬＰ払込期間 */
     palannaihuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ案内不要理由区分 */
     ratetuukasyukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* レート用通貨種類区分 */
     ratedai1hknkkn                                     CHAR        (2)                                                       NOT NULL  ,  /* レート用第１保険期間 */
     paldnendo                                          CHAR        (4)                                                       NOT NULL  ,  /* ＰＡＬＤ年度 */
     paldratenaikakucode                                CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬＤレート内定確定コード */
     drate00                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート００ */
     drate01                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート０１ */
     drate02                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート０２ */
     drate03                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート０３ */
     drate04                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート０４ */
     drate05                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート０５ */
     drate06                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート０６ */
     drate07                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート０７ */
     drate08                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート０８ */
     drate09                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート０９ */
     drate10                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート１０ */
     drate11                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート１１ */
     drate12                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート１２ */
     drate13                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート１３ */
     drate14                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート１４ */
     drate15                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート１５ */
     drate16                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート１６ */
     drate17                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート１７ */
     drate18                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート１８ */
     drate19                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート１９ */
     drate20                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート２０ */
     drate21                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート２１ */
     drate22                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート２２ */
     drate23                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート２３ */
     drate24                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート２４ */
     drate25                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート２５ */
     drate26                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート２６ */
     drate27                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート２７ */
     drate28                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート２８ */
     drate29                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート２９ */
     drate30                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート３０ */
     drate31                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート３１ */
     drate32                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート３２ */
     drate33                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート３３ */
     drate34                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート３４ */
     drate35                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート３５ */
     drate36                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート３６ */
     drate37                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート３７ */
     drate38                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート３８ */
     drate39                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート３９ */
     drate40                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート４０ */
     drate41                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート４１ */
     drate42                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート４２ */
     drate43                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート４３ */
     drate44                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート４４ */
     drate45                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート４５ */
     drate46                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート４６ */
     drate47                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート４７ */
     drate48                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート４８ */
     drate49                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート４９ */
     drate50                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート５０ */
     drate51                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート５１ */
     drate52                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート５２ */
     drate53                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート５３ */
     drate54                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート５４ */
     drate55                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート５５ */
     drate56                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート５６ */
     drate57                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート５７ */
     drate58                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート５８ */
     drate59                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート５９ */
     drate60                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート６０ */
     drate61                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート６１ */
     drate62                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート６２ */
     drate63                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート６３ */
     drate64                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート６４ */
     drate65                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート６５ */
     drate66                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート６６ */
     drate67                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート６７ */
     drate68                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート６８ */
     drate69                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート６９ */
     drate70                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート７０ */
     drate71                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート７１ */
     drate72                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート７２ */
     drate73                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート７３ */
     drate74                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート７４ */
     drate75                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート７５ */
     drate76                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート７６ */
     drate77                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート７７ */
     drate78                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート７８ */
     drate79                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート７９ */
     drate80                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート８０ */
     drate81                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート８１ */
     drate82                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート８２ */
     drate83                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート８３ */
     drate84                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート８４ */
     drate85                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート８５ */
     drate86                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート８６ */
     drate87                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート８７ */
     drate88                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート８８ */
     drate89                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート８９ */
     drate90                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート９０ */
     drate91                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート９１ */
     drate92                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート９２ */
     drate93                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート９３ */
     drate94                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート９４ */
     drate95                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート９５ */
     drate96                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート９６ */
     drate97                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート９７ */
     drate98                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート９８ */
     drate99                                            DECIMAL     (9,6)                                                               ,  /* Ｄレート９９ */
     dyouvrate00                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート００ */
     dyouvrate01                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート０１ */
     dyouvrate02                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート０２ */
     dyouvrate03                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート０３ */
     dyouvrate04                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート０４ */
     dyouvrate05                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート０５ */
     dyouvrate06                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート０６ */
     dyouvrate07                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート０７ */
     dyouvrate08                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート０８ */
     dyouvrate09                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート０９ */
     dyouvrate10                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート１０ */
     dyouvrate11                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート１１ */
     dyouvrate12                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート１２ */
     dyouvrate13                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート１３ */
     dyouvrate14                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート１４ */
     dyouvrate15                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート１５ */
     dyouvrate16                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート１６ */
     dyouvrate17                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート１７ */
     dyouvrate18                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート１８ */
     dyouvrate19                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート１９ */
     dyouvrate20                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート２０ */
     dyouvrate21                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート２１ */
     dyouvrate22                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート２２ */
     dyouvrate23                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート２３ */
     dyouvrate24                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート２４ */
     dyouvrate25                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート２５ */
     dyouvrate26                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート２６ */
     dyouvrate27                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート２７ */
     dyouvrate28                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート２８ */
     dyouvrate29                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート２９ */
     dyouvrate30                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート３０ */
     dyouvrate31                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート３１ */
     dyouvrate32                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート３２ */
     dyouvrate33                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート３３ */
     dyouvrate34                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート３４ */
     dyouvrate35                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート３５ */
     dyouvrate36                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート３６ */
     dyouvrate37                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート３７ */
     dyouvrate38                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート３８ */
     dyouvrate39                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート３９ */
     dyouvrate40                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート４０ */
     dyouvrate41                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート４１ */
     dyouvrate42                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート４２ */
     dyouvrate43                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート４３ */
     dyouvrate44                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート４４ */
     dyouvrate45                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート４５ */
     dyouvrate46                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート４６ */
     dyouvrate47                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート４７ */
     dyouvrate48                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート４８ */
     dyouvrate49                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート４９ */
     dyouvrate50                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート５０ */
     dyouvrate51                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート５１ */
     dyouvrate52                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート５２ */
     dyouvrate53                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート５３ */
     dyouvrate54                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート５４ */
     dyouvrate55                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート５５ */
     dyouvrate56                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート５６ */
     dyouvrate57                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート５７ */
     dyouvrate58                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート５８ */
     dyouvrate59                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート５９ */
     dyouvrate60                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート６０ */
     dyouvrate61                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート６１ */
     dyouvrate62                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート６２ */
     dyouvrate63                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート６３ */
     dyouvrate64                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート６４ */
     dyouvrate65                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート６５ */
     dyouvrate66                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート６６ */
     dyouvrate67                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート６７ */
     dyouvrate68                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート６８ */
     dyouvrate69                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート６９ */
     dyouvrate70                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート７０ */
     dyouvrate71                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート７１ */
     dyouvrate72                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート７２ */
     dyouvrate73                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート７３ */
     dyouvrate74                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート７４ */
     dyouvrate75                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート７５ */
     dyouvrate76                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート７６ */
     dyouvrate77                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート７７ */
     dyouvrate78                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート７８ */
     dyouvrate79                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート７９ */
     dyouvrate80                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート８０ */
     dyouvrate81                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート８１ */
     dyouvrate82                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート８２ */
     dyouvrate83                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート８３ */
     dyouvrate84                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート８４ */
     dyouvrate85                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート８５ */
     dyouvrate86                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート８６ */
     dyouvrate87                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート８７ */
     dyouvrate88                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート８８ */
     dyouvrate89                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート８９ */
     dyouvrate90                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート９０ */
     dyouvrate91                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート９１ */
     dyouvrate92                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート９２ */
     dyouvrate93                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート９３ */
     dyouvrate94                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート９４ */
     dyouvrate95                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート９５ */
     dyouvrate96                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート９６ */
     dyouvrate97                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート９７ */
     dyouvrate98                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート９８ */
     dyouvrate99                                        DECIMAL     (9,6)                                                               ,  /* Ｄ用Ｖレート９９ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_RisaHitSyouhnyouRateD2_Z ADD CONSTRAINT PK_RisaHitSyouhnyouRateD2 PRIMARY KEY (
     palhokensyuruikigou                                      , /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                               , /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                           , /* ＰＡＬ予定利率 */
     palpmencode                                              , /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                       , /* ＰＡＬ払込回数 */
     palhhknsei                                               , /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                      , /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                        , /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                            , /* ＰＡＬ保険期間 */
     palpharaikomikikan                                       , /* ＰＡＬＰ払込期間 */
     palannaihuyouriyuukbn                                    , /* ＰＡＬ案内不要理由区分 */
     ratetuukasyukbn                                          , /* レート用通貨種類区分 */
     ratedai1hknkkn                                           , /* レート用第１保険期間 */
     paldnendo                                                , /* ＰＡＬＤ年度 */
     paldratenaikakucode                                        /* ＰＡＬＤレート内定確定コード */
) ;
