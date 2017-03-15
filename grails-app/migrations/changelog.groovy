databaseChangeLog = {

    changeSet(author: "zhena (generated)", id: "1489554321191-1") {
        createSequence(sequenceName: "hibernate_sequence")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-2") {
        createTable(tableName: "candidate") {
            column(name: "id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "legal_status", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "person_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-3") {
        createTable(tableName: "login_authenticity") {
            column(name: "id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "access_token", type: "VARCHAR(255)")

            column(name: "account_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "password_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-4") {
        createTable(tableName: "login_authenticity_role") {
            column(name: "login_authenticity_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-5") {
        createTable(tableName: "person") {
            column(name: "id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "email", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "first_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "phone", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-6") {
        createTable(tableName: "reference") {
            column(name: "id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "person_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "position", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-7") {
        createTable(tableName: "request_map") {
            column(name: "id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "config_attribute", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "http_method", type: "VARCHAR(255)")

            column(name: "url", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-8") {
        createTable(tableName: "role") {
            column(name: "id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-9") {
        createTable(tableName: "role_group") {
            column(name: "id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-10") {
        createTable(tableName: "role_group_role") {
            column(name: "role_group_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-11") {
        createTable(tableName: "role_hierarchy_entry") {
            column(name: "id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "entry", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-12") {
        addPrimaryKey(columnNames: "id", constraintName: "candidate_pkey", tableName: "candidate")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-13") {
        addPrimaryKey(columnNames: "id", constraintName: "login_authenticity_pkey", tableName: "login_authenticity")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-14") {
        addPrimaryKey(columnNames: "login_authenticity_id, role_id", constraintName: "login_authenticity_role_pkey", tableName: "login_authenticity_role")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-15") {
        addPrimaryKey(columnNames: "id", constraintName: "person_pkey", tableName: "person")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-16") {
        addPrimaryKey(columnNames: "id", constraintName: "reference_pkey", tableName: "reference")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-17") {
        addPrimaryKey(columnNames: "id", constraintName: "request_map_pkey", tableName: "request_map")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-18") {
        addPrimaryKey(columnNames: "id", constraintName: "role_group_pkey", tableName: "role_group")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-19") {
        addPrimaryKey(columnNames: "role_group_id, role_id", constraintName: "role_group_role_pkey", tableName: "role_group_role")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-20") {
        addPrimaryKey(columnNames: "id", constraintName: "role_hierarchy_entry_pkey", tableName: "role_hierarchy_entry")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-21") {
        addPrimaryKey(columnNames: "id", constraintName: "role_pkey", tableName: "role")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-22") {
        addUniqueConstraint(columnNames: "name", constraintName: "uk_35hmlucbb2ndj6w0qxrocer9k", tableName: "role_group")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-23") {
        addUniqueConstraint(columnNames: "username", constraintName: "uk_fur8kbv1rcinrean9e40a85ev", tableName: "login_authenticity")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-24") {
        addUniqueConstraint(columnNames: "email", constraintName: "uk_fwmwi44u55bo4rvwsv0cln012", tableName: "person")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-25") {
        addUniqueConstraint(columnNames: "person_id", constraintName: "uk_huj5mp2r9mum09mcuxx1ojrao", tableName: "candidate")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-26") {
        addUniqueConstraint(columnNames: "authority", constraintName: "uk_irsamgnera6angm0prq1kemt2", tableName: "role")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-27") {
        addUniqueConstraint(columnNames: "entry", constraintName: "uk_k1j0pacdfek7h4o3te5ugab8e", tableName: "role_hierarchy_entry")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-28") {
        addUniqueConstraint(columnNames: "http_method, url", constraintName: "ukf721bf1f2340334e273dd57aedcb", tableName: "request_map")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-29") {
        addForeignKeyConstraint(baseColumnNames: "login_authenticity_id", baseTableName: "login_authenticity_role", constraintName: "fk7eq9op5ttdybyvpfp1hra6cl8", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "login_authenticity")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-30") {
        addForeignKeyConstraint(baseColumnNames: "person_id", baseTableName: "reference", constraintName: "fkjldkm7uhhswy2k1qkjili60wb", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "person")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-31") {
        addForeignKeyConstraint(baseColumnNames: "role_group_id", baseTableName: "role_group_role", constraintName: "fklu0ge9c3rhabcfu59589trt1m", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "role_group")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-32") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "login_authenticity_role", constraintName: "fkob6238fm8r61aew857rojogcg", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "role")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-33") {
        addForeignKeyConstraint(baseColumnNames: "person_id", baseTableName: "candidate", constraintName: "fkokwickkt0vhdvu2lfe05wtbsh", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "person")
    }

    changeSet(author: "zhena (generated)", id: "1489554321191-34") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "person", constraintName: "fkopl2f33pkcgdubo4hqfeik0pq", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "login_authenticity")
    }
}
