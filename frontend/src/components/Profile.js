import React, { useState, useEffect } from "react";
import AuthService from "../services/auth.service";
import establishmentService from "../services/establishmentService";

import Form from 'react-bootstrap/Form'

import { useNavigate } from 'react-router-dom';
import { useForm } from "react-hook-form";
import { render } from "@testing-library/react";
export default function Profile () {

  const [forceRender, setForceRender] = useState(false);

  const currentUser = AuthService.getCurrentUser();

  const [establishment, setEstablishment] = useState([]);

  useEffect(() => {
      // code to run after render goes here
      establishmentService.getEstablishments() .then((response) => {
          
        // console.log( response.data);
        setEstablishment(response.data);
        //console.log(establishment);
      });
    
  }, [forceRender]); // <-- empty array means 'run once'


  const onSubmit = data => {
    console.log(data);
    establishmentService.insertEstablihsment(data.name, data.code, data.address).then((response) => {
      
    });
    setForceRender(!forceRender);

};

      const { 
        register, 
        handleSubmit, 

        formState: { errors } 
      } = useForm({ mode: 'onSubmit', reValidateMode: 'onSubmit' });
      const navigate = useNavigate();

    return (
      <div className="container">
        <header className="jumbotron">
          <h3>
            <strong>{currentUser.username}</strong> Profile
          </h3>
        </header>
        <p>
          <strong>Id:</strong> {currentUser.id}
        </p>
        <p>
          <strong>text:</strong> {currentUser.text}
        </p>
        <strong>Authorities:</strong>
        <ul>
          {currentUser.roles &&
            currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
        </ul>



        <div>
          <div>
            <form onSubmit={handleSubmit(onSubmit)}>
              {/* <h2 className="sr-only">Login Form</h2> */}
              
              <div className="form-group">
                <input defaultValue="test"
                  {...register("name", { required: true })}
                  className="form-control"
                  //validating by email
                  // type="email"
                  name="email"
                  placeholder="Email"

                />
              </div>
              <div className="form-group">
                <input defaultValue="123"
                  {...register("code", { required: true })}
                  className="form-control"
                  //validating by email
                  // type="email"
                  placeholder="Email"
                  type = "number"
                />
              </div>
              <div className="form-group">
                <input defaultValue="test"
                  {...register("address", { required: true })}
                  className="form-control"
                  //validating by email
                  // type="email"
                  name="email"
                  placeholder="Email"

                />
              </div>
              <div className="form-group">
                <button
                  className="btn btn-primary btn-block col-12 mb-3"
                  type="submit"
                >
                  Log In
                </button>
              </div>
              
            </form>
          </div>
          <header className="jumbotron">
            {/* <h3>
              <ul>
                {establishment.establishmentName &&
                  establishment.establishmentName.map((name, index) => <li key={index}>{name}</li>)}
              </ul>
            </h3> */}
            {establishment.map((est) => {
              return (
                <div key={est.id}>
                  <h1>{est.id}</h1>
                  <div>{est.establishmentName}</div>
                  <div>{est.code}</div>
                  <div>{est.address}</div>
                </div>
              )
            })}
          </header>
        </div>




      </div>
    );
  };
