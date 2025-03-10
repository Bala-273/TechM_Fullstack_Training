import React from "react";
import { useForm } from "react-hook-form";
import "./LoginForm.css"

const LoginForm = ({ onLogin }) => {
  const {
    register,
    handleSubmit,
    formState: { errors },
    reset,
  } = useForm();

  const onSubmit = (data) => {
    const username = data.username;
    const password = data.password;

    // Check credentials (you can customize this part)
    if (username === "BalaK" && password === "password") {
      onLogin(username);
      reset(); // Clear the form after successful login
    } else {
      alert("Invalid Credentials");
    }
  };

  return (
    <div className="login-form">
      <h3>Login</h3>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div className="mb-3">
          <label>Username</label>
          <input
            type="text"
            className="form-control"
            {...register("username", { required: "Username is required" })}
          />
          {errors.username && (
            <p className="text-danger">{errors.username.message}</p>
          )}
        </div>

        <div className="mb-3">
          <label>Password</label>
          <input
            type="password"
            className="form-control"
            {...register("password", { required: "Password is required" })}
          />
          {errors.password && (
            <p className="text-danger">{errors.password.message}</p>
          )}
        </div>

        <button type="submit" className="btn btn-primary w-100">
          Login
        </button>
      </form>
    </div>
  );
};

export default LoginForm;
