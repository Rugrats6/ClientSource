package com.example.clientsource;

import java.util.Date;

import android.provider.BaseColumns;

//FYI: This is the same setup as PetTracker, but we're adding a few fields for storing image URis
public final class ClientSourceDatabase {

    private ClientSourceDatabase() {}
    
    // Child Info Table
    public static final class Child implements BaseColumns {

        private Child() {}
        
        public static final String CHILD_ID = "child_id";
        
        public static final String CHILD_TABLE_INFO = "child_info";
        
        public static final String LAST_NAME = "last_name";
        public static final String FIRST_NAME = "first_name";
        public static final String   DATEOF_BIRTH = "dateof_birth";
        public static final String SEX = "sex";
        public static final String SS_NUMBER = "ss_number";
        
        public static final String PARENT_ID = "parent_id";
        public static final String TIME_ID = "time_id";
        //public static final String DEFAULT_SORT_ORDER = "pet_name ASC";
    }
    
    
    
    // Parents table
    public static final class Parent implements BaseColumns {

        private Parent() {}
        
        public static final String PARENT_ID = "parent_id";
        
        public static final String PARENT_TABLE_NAME = "table_parent";
        
        public static final String LAST_NAME = "last_name";
        public static final String FIRST_NAME = "first_name";
        public static final String   DATEOF_BIRTH = "dateof_birth";
        public static final String SEX = "sex";
        public static final String SS_NUMBER = "ss_number";
        public static final String PHONE_NUMBER = "phone_number";
        
        public static final String CHILD_ID = "child_id";
        
        
        //public static final String DEFAULT_SORT_ORDER = "pet_type ASC";
    }   
        
    //Time Table
    public static final class Time implements BaseColumns {

        private Time() {}
            
        public static final String TIME_ID = "time_id";
        
        public static final String TIME_TABLE_NAME = "table_time";
        public static final String DATE = "date";
        public static final String CHECK_IN = "check_in";
        public static final String   CHECK_OUT = "check_out";

        
    }
}