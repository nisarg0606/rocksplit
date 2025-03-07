-- Users Table
CREATE TABLE users (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255),
    phone VARCHAR(20),
    profile_picture VARCHAR(255),
    auth_provider VARCHAR(20) NOT NULL DEFAULT 'LOCAL',
    provider_id VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    default_currency VARCHAR(3) NOT NULL DEFAULT 'USD'
);

-- Groups Table
CREATE TABLE groups (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    created_by UUID NOT NULL REFERENCES users(id),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    group_image VARCHAR(255),
    currency VARCHAR(3) NOT NULL DEFAULT 'USD'
);

-- Many-to-Many relationship between Users and Groups
CREATE TABLE user_groups (
    user_id UUID NOT NULL REFERENCES users(id),
    group_id UUID NOT NULL REFERENCES groups(id),
    PRIMARY KEY (user_id, group_id)
);

-- Categories Table
CREATE TABLE categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    icon VARCHAR(255),
    color VARCHAR(20),
    parent_id BIGINT REFERENCES categories(id),
    keywords TEXT,
    system_defined BOOLEAN NOT NULL DEFAULT FALSE
);

-- Expenses Table
CREATE TABLE expenses (
    id UUID PRIMARY KEY,
    group_id UUID NOT NULL REFERENCES groups(id),
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(19,4) NOT NULL,
    paid_by UUID NOT NULL REFERENCES users(id),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    expense_date TIMESTAMP,
    category_id BIGINT REFERENCES categories(id),
    split_type VARCHAR(20) NOT NULL DEFAULT 'EQUAL',
    receipt_image VARCHAR(255),
    receipt_text TEXT,
    merchant VARCHAR(255),
    location VARCHAR(255),
    recurring BOOLEAN NOT NULL DEFAULT FALSE,
    recurrence_pattern VARCHAR(20)
);

-- ExpenseSplits Table
CREATE TABLE expense_splits (
    id BIGSERIAL PRIMARY KEY,
    expense_id UUID NOT NULL REFERENCES expenses(id),
    user_id UUID NOT NULL REFERENCES users(id),
    amount DECIMAL(19,4) NOT NULL,
    percentage DECIMAL(5,2),
    shares INTEGER,
    settled BOOLEAN NOT NULL DEFAULT FALSE
);

-- Settlements Table
CREATE TABLE settlements (
    id UUID PRIMARY KEY,
    from_user_id UUID NOT NULL REFERENCES users(id),
    to_user_id UUID NOT NULL REFERENCES users(id),
    group_id UUID REFERENCES groups(id),
    amount DECIMAL(19,4) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    notes TEXT,
    method VARCHAR(20),
    settlement_proof VARCHAR(255)
);

-- Budgets Table
CREATE TABLE budgets (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id),
    group_id UUID REFERENCES groups(id),
    category_id BIGINT REFERENCES categories(id),
    name VARCHAR(100) NOT NULL,
    description TEXT,
    amount DECIMAL(19,4) NOT NULL,
    start_date DATE,
    end_date DATE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    period_type VARCHAR(20),
    ai_generated BOOLEAN NOT NULL DEFAULT FALSE
);

-- Notifications Table
CREATE TABLE notifications (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id),
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    type VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    read BOOLEAN NOT NULL DEFAULT FALSE,
    reference_id VARCHAR(255),
    reference_type VARCHAR(50)
);

-- Receipt Analysis Table
CREATE TABLE receipt_analyses (
    id BIGSERIAL PRIMARY KEY,
    expense_id UUID UNIQUE NOT NULL REFERENCES expenses(id),
    extracted_items JSONB,
    confidence_score DECIMAL(5,4),
    raw_text TEXT,
    suggested_category_id BIGINT REFERENCES categories(id),
    category_confidence DECIMAL(5,4),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    processing_status VARCHAR(20) NOT NULL DEFAULT 'PENDING'
);

-- Friendships Table
CREATE TABLE friendships (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id),
    friend_id UUID NOT NULL REFERENCES users(id),
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP,
    UNIQUE (user_id, friend_id)
);

-- Insert default categories
INSERT INTO categories (name, icon, color, system_defined) VALUES
('Food & Drinks', 'restaurant', '#FF5722', true),
('Housing', 'home', '#2196F3', true),
('Transportation', 'directions_car', '#4CAF50', true),
('Entertainment', 'movie', '#9C27B0', true),
('Healthcare', 'healing', '#F44336', true),
('Utilities', 'power', '#607D8B', true),
('Groceries', 'shopping_basket', '#FF9800', true),
('Travel', 'flight', '#3F51B5', true),
('Shopping', 'shopping_cart', '#795548', true),
('Other', 'more_horiz', '#9E9E9E', true);